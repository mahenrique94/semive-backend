package br.com.matheuscastiglioni.semivebackend.domain.order;

import br.com.matheuscastiglioni.semivebackend.custom.CustomInstantDeserializer;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @Column(columnDefinition = "date", name = "date_delivery", nullable = false)
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    private Instant dateDelivery;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public Order() {}
    public Order(Long id) {
        this();
        setId(id);
    }
    public Order(Person idPerson, Instant dateDelivery) {
        this.idPerson = idPerson;
        this.dateDelivery = dateDelivery;
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
    public Instant getDateDelivery() {
        return dateDelivery;
    }
    public void setDateDelivery(Instant dateDelivery) {
        this.dateDelivery = dateDelivery;
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
