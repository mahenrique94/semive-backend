package br.com.matheuscastiglioni.semivebackend.domain.product.value;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/value")
public class ProductValueController extends GenericController<ProductValue, ProductValueService, Long> {

    public ProductValueController(ProductValueService service) {
        super(service);
    }

}
