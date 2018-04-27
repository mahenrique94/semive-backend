package br.com.matheuscastiglioni.semivebackend.domain.product.value;

import br.com.matheuscastiglioni.semivebackend.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "products_values")
public class ProductValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_product", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Product idProduct;
    @NotNull
    @Digits(integer = 18, fraction = 2)
    @DecimalMax(value = "999999999.99")
    @DecimalMin(value = "0.0")
    @Column(columnDefinition = "numeric(18, 2)", name = "value", nullable = false)
    private BigDecimal value;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public ProductValue() {}
    public ProductValue(Long id) {
        this();
        setId(id);
    }
    public ProductValue(Product product) {
        this();
        setIdProduct(product);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Product getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
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
        setValue(new BigDecimal(0.0));
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setDateUpdated(Instant.now());
    }

}
