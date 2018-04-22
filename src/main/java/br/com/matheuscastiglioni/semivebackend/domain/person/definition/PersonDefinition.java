package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.domain.person.group.PersonGroup;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_definitions")
@DynamicUpdate(value = true)
@DynamicInsert(value = true)
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
    @JsonBackReference
    private PersonGroup idGroup;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdate;

    public PersonDefinition() {
        setDateCreated(Instant.now());
        setDateUpdate(Instant.now());
    }
    public PersonDefinition(Long id) {
        this();
        setId(id);
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
    public Instant getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Instant getDateUpdate() {
        return dateUpdate;
    }
    public void setDateUpdate(Instant dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
