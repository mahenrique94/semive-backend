package br.com.matheuscastiglioni.semivebackend.domain.product;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends GenericController<Product, ProductService, Long> {

    public ProductController(ProductService service) {
        super(service);
    }

}
