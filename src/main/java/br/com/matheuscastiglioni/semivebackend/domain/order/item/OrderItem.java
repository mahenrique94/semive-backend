package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.domain.order.Order;
import br.com.matheuscastiglioni.semivebackend.domain.product.Product;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "orders_items")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id")
    private Order idOrder;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_product", nullable = false, referencedColumnName = "id")
    private Product idProduct;
    @NotNull
    @Digits(integer = 18, fraction = 2)
    @DecimalMax(value = "999999999.99")
    @DecimalMin(value = "0.0")
    @Column(columnDefinition = "numeric(18, 2)", name = "count", nullable = false)
    private BigDecimal count;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;

    public OrderItem() {}
    public OrderItem(Long id) {
        this();
        setId(id);
    }
    public OrderItem(Order idOrder, Product idProduct, BigDecimal count) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.count = count;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Order getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
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
        setDateCreated(Instant.now());
        setDateUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        setDateUpdated(Instant.now());
    }

}
