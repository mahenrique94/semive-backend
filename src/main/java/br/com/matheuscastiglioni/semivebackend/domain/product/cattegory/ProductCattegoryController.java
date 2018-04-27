package br.com.matheuscastiglioni.semivebackend.domain.product.cattegory;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/cattegory")
public class ProductCattegoryController extends GenericController<ProductCattegory, ProductCattegoryService, Integer> {

    public ProductCattegoryController(ProductCattegoryService service) {
        super(service);
    }

}
