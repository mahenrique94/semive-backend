package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order/item")
public class OrderItemController extends GenericController<OrderItem, OrderItemService, Long> {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService service) {
        super(service);
        this.orderItemService = service;
    }

    @GetMapping("order/{idOrder}")
    public ResponseEntity<List<OrderItem>> listByIdOrder(@PathVariable Long idOrder) {
        List<OrderItem> orderItems = this.orderItemService.listByIdOrder(idOrder);
        if (orderItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderItems);
    }

}
