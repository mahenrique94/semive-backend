package br.com.matheuscastiglioni.semivebackend.domain.product.value;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProductValueService extends GenericService<ProductValue, ProductValueRepository, Long> {

    public ProductValueService(ProductValueRepository repository) {
        super(repository);
    }

}
