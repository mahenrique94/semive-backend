package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.domain.address.type.AddressType;
import br.com.matheuscastiglioni.semivebackend.domain.city.City;
import br.com.matheuscastiglioni.semivebackend.domain.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "persons_addresses", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_person", "id_city", "id_type", "address", "number", "zipcode", "district"})})
public class PersonAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false, referencedColumnName = "id")
    private Person idPerson;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_city", nullable = false, referencedColumnName = "id")
    private City idCity;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_type", nullable = false, referencedColumnName = "id")
    private AddressType idType;
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
    private String zipCode;
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
    public AddressType getIdType() {
        return idType;
    }
    public void setIdType(AddressType idType) {
        this.idType = idType;
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
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
    public City getIdCity() {
        return idCity;
    }
    public void setIdCity(City idCity) {
        this.idCity = idCity;
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
