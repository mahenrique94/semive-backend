package br.com.matheuscastiglioni.semivebackend.domain.product.cattegory;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProductCattegoryService extends GenericService<ProductCattegory, ProductCattegoryRepository, Integer> {

    public ProductCattegoryService(ProductCattegoryRepository repository) {
        super(repository);
    }

}
