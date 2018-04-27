package br.com.matheuscastiglioni.semivebackend.domain.product;

import br.com.matheuscastiglioni.semivebackend.domain.product.stock.ProductStock;
import br.com.matheuscastiglioni.semivebackend.domain.product.type.ProductType;
import br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValue;
import br.com.matheuscastiglioni.semivebackend.domain.unity.Unity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_type", nullable = false, referencedColumnName = "id")
    private ProductType idType;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_unity", nullable = false, referencedColumnName = "id")
    private Unity idUnity;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 120)
    @Pattern(message = "{pattern.spaceLetterNumberBarCommaDashDot}", regexp = "^(([aA-zZ\\d\\.\\/\\-,])+(\\s[aA-zZ\\d\\.\\/\\-,]+)*)$")
    @Column(columnDefinition = "varchar(120)", length = 120, name = "description", nullable = false, unique = true)
    private String description;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.spaceLetterNumber}", regexp = "^(([aA-zZ\\d])+(\\s[aA-zZ\\d]+)*)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "brand", nullable = true)
    private String brand;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.letterNumber}", regexp = "^([aA-zZ\\d]+)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "bar_code", nullable = true, unique = true)
    private String barCode;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "idProduct")
    @JsonManagedReference
    private ProductStock stock;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "idProduct")
    @JsonManagedReference
    private ProductValue value;

    public Product() {}
    public Product(Long id) {
        this();
        setId(id);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProductType getIdType() {
        return idType;
    }
    public void setIdType(ProductType idType) {
        this.idType = idType;
    }
    public Unity getIdUnity() {
        return idUnity;
    }
    public void setIdUnity(Unity idUnity) {
        this.idUnity = idUnity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBarCode() {
        return barCode;
    }
    public void setBarCode(String barCode) {
        this.barCode = barCode;
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
    public ProductStock getStock() {
        return stock;
    }
    public ProductValue getValue() {
        return value;
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
