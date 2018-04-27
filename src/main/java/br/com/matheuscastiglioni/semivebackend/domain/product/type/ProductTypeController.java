package br.com.matheuscastiglioni.semivebackend.domain.product.type;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/type")
public class ProductTypeController extends GenericController<ProductType, ProductTypeService, Integer> {

    public ProductTypeController(ProductTypeService service) {
        super(service);
    }

}
