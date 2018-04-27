package br.com.matheuscastiglioni.semivebackend.domain.product;

import br.com.matheuscastiglioni.semivebackend.domain.product.stock.ProductStock;
import br.com.matheuscastiglioni.semivebackend.domain.product.stock.ProductStockRepository;
import br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValue;
import br.com.matheuscastiglioni.semivebackend.domain.product.value.ProductValueRepository;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, ProductRepository, Long> {

    private ProductStockRepository productStockRepository;
    private ProductValueRepository productValueRepository;

    @Autowired
    public ProductService(ProductRepository repository, ProductStockRepository productStockRepository, ProductValueRepository productValueRepository) {
        super(repository);
        this.productStockRepository = productStockRepository;
        this.productValueRepository = productValueRepository;
    }

    @Override
    public Product save(Product product) {
        product = super.save(product);
        if (product.getId() != null) {
            this.productStockRepository.save(new ProductStock(product));
            this.productValueRepository.save(new ProductValue(product));
        }
        return product;
    }
}
