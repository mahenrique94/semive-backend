package br.com.matheuscastiglioni.semivebackend.domain.country;

import br.com.matheuscastiglioni.semivebackend.custom.BrazilianInstantSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "countries")
public class Country implements Serializable {

    @Id
    private Integer id;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.letter}", regexp = "^([aA-zZ]*)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "description", nullable = false, unique = true)
    private String description;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateUpdated;

    public Country() {}
    public Country(Integer id) {
        this();
        setId(id);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
