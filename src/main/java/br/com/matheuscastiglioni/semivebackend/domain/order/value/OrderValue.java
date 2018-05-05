package br.com.matheuscastiglioni.semivebackend.domain.order.value;

import br.com.matheuscastiglioni.semivebackend.domain.order.Order;
import br.com.matheuscastiglioni.semivebackend.domain.order.item.OrderItem;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders_values")
public class OrderValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id")
    private Order idOrder;
    @Transient
    @Formula("(select sum(item.count * prodv.value) from orders_items item, products prod, products_values prodv where item.id_product = prod.id and prodv.id_product = prod.id and item.id_order = id_order)")
    @Digits(integer = 18, fraction = 2)
    @DecimalMax(value = "999999999.99")
    @DecimalMin(value = "0.0")
    private BigDecimal total;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    private Instant dateUpdated;
    @OneToMany
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id_order", insertable = false, updatable = false)
    private List<OrderItem> items;

    public OrderValue() {}
    public OrderValue(Long id) {
        this();
        setId(id);
    }
    public OrderValue(Order order) {
        this();
        setIdOrder(order);
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
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
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
