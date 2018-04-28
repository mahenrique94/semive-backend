package br.com.matheuscastiglioni.semivebackend.domain.city;

import br.com.matheuscastiglioni.semivebackend.domain.state.State;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "cities")
public class City implements Serializable {

    @Id
    private Integer id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_state", nullable = false, referencedColumnName = "id")
    private State idState;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 60)
    @Pattern(message = "{pattern.letter}", regexp = "^([aA-zZ]*)$")
    @Column(columnDefinition = "varchar(60)", length = 60, name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public City() {}
    public City(Integer id) {
        this();
        setId(id);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public State getIdState() {
        return idState;
    }
    public void setIdState(State idState) {
        this.idState = idState;
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
