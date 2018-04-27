package br.com.matheuscastiglioni.semivebackend.domain.product.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
}
