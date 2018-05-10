package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;

import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_contacts")
public class PersonContact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 120)
    @Pattern(message = "{pattern.spaceLetter}", regexp = "^(([aA-zZ])+(\\s[aA-zZ]+)*)$")
    @Column(columnDefinition = "varchar(120)", length = 120, name = "name", nullable = false)
    private String name;
    @Range(min = 0, max = 99)
    @Column(name = "area_code", nullable = true)
    private Integer areaCode;
    @Size(min = 0, max = 9)
    @Pattern(message = "{pattern.telephone}", regexp = "^(([\\d]{4})([\\-])([\\d]{4}))$")
    @Column(columnDefinition = "varchar(9)", length = 9, name = "telephone", nullable = true)
    private String telephone;
    @Size(min = 0, max = 10)
    @Pattern(message = "{pattern.telephone}", regexp = "^(([\\d]{5})([\\-])([\\d]{4}))$")
    @Column(columnDefinition = "varchar(10)", length = 10, name = "cellphone", nullable = true)
    private String cellphone;
    @Size(min = 0, max = 255)
    @Pattern(message = "{pattern.telephone}", regexp = "^(([aA-zZ\\d\\w\\.\\-]+)([@])([\\daA-zZ]+)([\\.])([aA-zZ]+)(([\\.])([aA-zZ])+)*)$")
    @Column(columnDefinition = "varchar(255)", length = 255, name = "email", nullable = true)
    private String email;
    @NotNull
    @Column(columnDefinition = "boolean", name = "active", nullable = false)
    private Boolean active;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public PersonContact() {}
    public PersonContact(Long id) {
        this();
        setId(id);
    }
    public PersonContact(Person idPerson, String name, String email) {
        this.idPerson = idPerson;
        this.name = name;
        this.email = email;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
