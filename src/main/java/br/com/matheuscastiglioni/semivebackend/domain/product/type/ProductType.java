package br.com.matheuscastiglioni.semivebackend.domain.product.type;

import br.com.matheuscastiglioni.semivebackend.custom.BrazilianInstantSerializer;
import br.com.matheuscastiglioni.semivebackend.domain.product.cattegory.ProductCattegory;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "products_types", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_cattegory", "description"})})
public class ProductType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_cattegory", nullable = false, referencedColumnName = "id")
    private ProductCattegory idCattegory;
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 30)
    @Pattern(message = "{pattern.spaceLetterNumber}", regexp = "^(([aA-zZ\\d])+(\\s[aA-zZ\\d]+)*)$")
    @Column(columnDefinition = "varchar(30)", length = 30, name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(columnDefinition = "boolean", name = "active", nullable = false)
    private Boolean active;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_created", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateCreated;
    @NotNull
    @Column(columnDefinition = "timestamp", name = "date_updated", nullable = false)
    @JsonSerialize(using = BrazilianInstantSerializer.class)
    private Instant dateUpdated;

    public ProductType() {}
    public ProductType(Integer id) {
        this();
        setId(id);
    }
    public ProductType(ProductCattegory idCattegory, String description) {
        this.idCattegory = idCattegory;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public ProductCattegory getIdCattegory() {
        return idCattegory;
    }
    public void setIdCattegory(ProductCattegory idCattegory) {
        this.idCattegory = idCattegory;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
