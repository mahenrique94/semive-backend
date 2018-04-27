package br.com.matheuscastiglioni.semivebackend.domain.product.stock;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product/stock")
public class ProductStockController extends GenericController<ProductStock, ProductStockService, Long> {

    public ProductStockController(ProductStockService service) {
        super(service);
    }

}
