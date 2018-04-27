package br.com.matheuscastiglioni.semivebackend.domain.product.type;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService extends GenericService<ProductType, ProductTypeRepository, Integer> {

    public ProductTypeService(ProductTypeRepository repository) {
        super(repository);
    }

}
