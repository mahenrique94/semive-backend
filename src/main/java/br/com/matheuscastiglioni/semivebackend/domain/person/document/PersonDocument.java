package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.domain.document.DocumentType;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_documents")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
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
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdate;

    public PersonDocument() {
        setDateCreated(Instant.now());
        setDateUpdate(Instant.now());
    }
    public PersonDocument(Long id) {
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
