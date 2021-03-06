package br.com.matheuscastiglioni.semivebackend.domain.product.stock;

import br.com.matheuscastiglioni.semivebackend.custom.BrazilianInstantSerializer;
import br.com.matheuscastiglioni.semivebackend.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "products_stocks")
public class ProductStock implements Serializable {

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
    @Column(columnDefinition = "numeric(18, 2)", name = "count", nullable = false)
    private BigDecimal count;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateUpdated;

    public ProductStock() {}
    public ProductStock(Long id) {
        this();
        setId(id);
    }
    public ProductStock(Product product) {
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
    public BigDecimal getCount() {
        return count;
    }
    public void setCount(BigDecimal count) {
        this.count = count;
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
        setCount(new BigDecimal(0.0));
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setDateUpdated(Instant.now());
    }

}
