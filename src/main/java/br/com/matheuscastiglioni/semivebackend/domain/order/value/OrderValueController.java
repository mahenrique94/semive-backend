package br.com.matheuscastiglioni.semivebackend.domain.order.value;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order/value")
public class OrderValueController extends GenericController<OrderValue, OrderValueService, Long> {

    public OrderValueController(OrderValueService service) {
        super(service);
    }

}
