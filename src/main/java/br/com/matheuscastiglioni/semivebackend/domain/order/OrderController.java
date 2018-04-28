package br.com.matheuscastiglioni.semivebackend.domain.order;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends GenericController<Order, OrderService, Long> {

    public OrderController(OrderService service) {
        super(service);
    }

}
