package br.com.matheuscastiglioni.semivebackend.domain.person;

import br.com.matheuscastiglioni.semivebackend.custom.CustomInstantDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons")
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
    @Column(columnDefinition = "boolean", name = "active", nullable = false)
    private Boolean active;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public Person() {}
    public Person(Long id) {
        this();
        setId(id);
    }
    public Person(String name, String sex, Instant dateBorn) {
        this.name = name;
        this.sex = sex;
        this.dateBorn = dateBorn;
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
