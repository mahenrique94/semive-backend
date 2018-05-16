package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.domain.order.Order;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService extends GenericService<OrderItem, OrderItemRepository, Long> {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository repository) {
        super(repository);
        this.orderItemRepository = repository;
    }

    public List<OrderItem> listByIdOrder(Long idOrder) {
        return this.orderItemRepository.findByIdOrder(new Order(idOrder));
    }

}
