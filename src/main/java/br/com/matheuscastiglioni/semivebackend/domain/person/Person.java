package br.com.matheuscastiglioni.semivebackend.domain.person;

import br.com.matheuscastiglioni.semivebackend.custom.CustomInstantDeserializer;
import br.com.matheuscastiglioni.semivebackend.domain.person.document.PersonDocument;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name = "persons")
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 120)
    @Pattern(message = "{pattern.spaceLetter}", regexp = "^(([aA-zZ])+(\\s[aA-zZ]+)*)$")
    @Column(columnDefinition = "varchar(120)", length = 120, name = "name", nullable = false)
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 1)
    @Pattern(message = "{pattern.sex}", regexp = "^(([F])|([M]))$")
    @Column(columnDefinition = "char(1)", length = 1, name = "sex", nullable = false)
    private String sex;
    @NotNull
    @Column(columnDefinition = "date", name = "date_born", nullable = false)
    @JsonDeserialize(using = CustomInstantDeserializer.class)
    private Instant dateBorn;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public Person() {
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }
    public Person(Long id) {
        this();
        setId(id);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Instant getDateBorn() {
        return dateBorn;
    }
    public void setDateBorn(Instant dateBorn) {
        this.dateBorn = dateBorn;
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

}
