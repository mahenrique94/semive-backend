package br.com.matheuscastiglioni.semivebackend.domain.product.stock;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService extends GenericService<ProductStock, ProductStockRepository, Long> {

    public ProductStockService(ProductStockRepository repository) {
        super(repository);
    }

}
