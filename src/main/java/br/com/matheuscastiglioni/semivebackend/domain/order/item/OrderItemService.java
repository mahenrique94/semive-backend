package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends GenericService<OrderItem, OrderItemRepository, Long> {

    public OrderItemService(OrderItemRepository repository) {
        super(repository);
    }

}
