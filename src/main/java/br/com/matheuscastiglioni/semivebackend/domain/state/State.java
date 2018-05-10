package br.com.matheuscastiglioni.semivebackend.domain.state;

import br.com.matheuscastiglioni.semivebackend.custom.BrazilianInstantSerializer;
import br.com.matheuscastiglioni.semivebackend.domain.country.Country;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "states")
public class State implements Serializable {

    @Id
    private Integer id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_country", nullable = false, referencedColumnName = "id")
    private Country idCountry;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.letter}", regexp = "^([aA-zZ]*)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "description", nullable = false, unique = true)
    private String description;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 2)
    @Pattern(message = "{pattern.letter}", regexp = "^([aA-zZ]*)$")
    @Column(columnDefinition = "char(2)", length = 2, name = "state", nullable = false, unique = true)
    private String state;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateUpdated;

    public State() {}
    public State(Integer id) {
        this();
        setId(id);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Country getIdCountry() {
        return idCountry;
    }
    public void setIdCountry(Country idCountry) {
        this.idCountry = idCountry;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Instant getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Instant getDateUpdated() {
        return dateUpdated;
    }
    public void setDateUpdated(Instant dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @PrePersist
    public void prePersist() {
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setDateUpdated(Instant.now());
    }

}
