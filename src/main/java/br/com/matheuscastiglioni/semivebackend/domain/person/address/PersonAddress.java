package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_addresses", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_person", "type", "address", "number", "zipcode", "district", "city", "country"})})
public class PersonAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 10)
    @Pattern(message = "{pattern.letter}", regexp = "^([aA-zZ]*)$")
    @Column(columnDefinition = "varchar(10)", length = 10, name = "type", nullable = false)
    private String type;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 60)
    @Pattern(message = "{pattern.spaceLetterNumberDot}", regexp = "^(([aA-zZ\\d\\.])+(\\s[aA-zZ\\d\\.]+)*)$")
    @Column(columnDefinition = "varchar(60)", length = 60, name = "address", nullable = false)
    private String address;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 10)
    @Pattern(message = "{pattern.addressNumber}", regexp = "^(([aA-zZ\\d])*([S\\/N])*)$")
    @Column(columnDefinition = "varchar(10)", length = 10, name = "number", nullable = false)
    private String number;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 10)
    @Pattern(message = "{pattern.addressNumber}", regexp = "^(([\\d]){5}([\\-])([\\d]{3}))$")
    @Column(columnDefinition = "varchar(10)", length = 10, name = "zipcode", nullable = false)
    private String zipcode;
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.spaceLetterNumberBarDotDashComma}", regexp = "^(([aA-zZ\\d\\.\\/\\-,])+(\\s[aA-zZ\\d\\.\\/\\-,]+)*)$")
    @Column(columnDefinition = "varchar(60)", length = 30, name = "complement", nullable = true)
    private String complement;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 60)
    @Pattern(message = "{pattern.spaceLetterNumberDot}", regexp = "^(([aA-zZ\\d\\.])+(\\s[aA-zZ\\d\\.]+)*)$")
    @Column(columnDefinition = "varchar(60)", length = 60, name = "district", nullable = false)
    private String district;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 60)
    @Pattern(message = "{pattern.city}", regexp = "^(([aA-zZ\\'])+(\\s[aA-zZ\\']+)*)$")
    @Column(columnDefinition = "varchar(60)", length = 60, name = "city", nullable = false)
    private String city;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 2)
    @Pattern(message = "{pattern.state}", regexp = "^([AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO|EX]{2})$")
    @Column(columnDefinition = "char(2)", length = 2, name = "state", nullable = false)
    private String state;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.spaceLetter}", regexp = "^(([aA-zZ])+(\\s[aA-zZ]+)*)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "country", nullable = false)
    private String country;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public PersonAddress() {}
    public PersonAddress(Long id) {
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
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
