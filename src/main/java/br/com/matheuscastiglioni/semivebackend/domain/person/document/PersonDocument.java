package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.domain.document.type.DocumentType;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_documents", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_person", "id_type"})})
public class PersonDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false, referencedColumnName = "id")
    private DocumentType idType;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.letterNumberDotDash}", regexp = "^([A-Z\\d\\.\\-]+)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "value", nullable = false, unique = true)
    private String value;
    @NotNull
    @Column(columnDefinition = "boolean", name = "active", nullable = false)
    private Boolean active;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public PersonDocument() {}
    public PersonDocument(Long id) {
        this();
        setId(id);
    }
    public PersonDocument(Person idPerson, DocumentType idType, String value) {
        this.idPerson = idPerson;
        this.idType = idType;
        this.value = value;
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
    public DocumentType getIdType() {
        return idType;
    }
    public void setIdType(DocumentType idType) {
        this.idType = idType;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
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
