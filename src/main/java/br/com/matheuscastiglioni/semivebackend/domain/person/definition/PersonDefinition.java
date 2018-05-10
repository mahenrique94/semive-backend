package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.domain.person.group.PersonGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_definitions", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_person", "id_group"})})
public class PersonDefinition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_group", nullable = false, referencedColumnName = "id")
    private PersonGroup idGroup;
    @NotNull
    @Column(columnDefinition = "boolean", name = "active", nullable = false)
    private Boolean active;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public PersonDefinition() {}
    public PersonDefinition(Long id) {
        this();
        setId(id);
    }
    public PersonDefinition(Person idPerson, PersonGroup idGroup) {
        this.idPerson = idPerson;
        this.idGroup = idGroup;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Person getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }
    public PersonGroup getIdGroup() {
        return idGroup;
    }
    public void setIdGroup(PersonGroup idGroup) {
        this.idGroup = idGroup;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
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
        setActive(true);
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setDateUpdated(Instant.now());
    }

}
