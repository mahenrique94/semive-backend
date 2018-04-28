package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/item")
public class OrderItemController extends GenericController<OrderItem, OrderItemService, Long> {

    public OrderItemController(OrderItemService service) {
        super(service);
    }

}
