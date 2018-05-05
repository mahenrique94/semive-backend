package br.com.matheuscastiglioni.semivebackend.domain.order;

import br.com.matheuscastiglioni.semivebackend.domain.order.value.OrderValue;
import br.com.matheuscastiglioni.semivebackend.domain.order.value.OrderValueRepository;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Order, OrderRepository, Long> {

    private final OrderValueRepository orderValueRepository;

    @Autowired
    public OrderService(OrderRepository repository, OrderValueRepository orderValueRepository) {
        super(repository);
        this.orderValueRepository = orderValueRepository;
    }

    @Override
    public Order save(Order order) {
        order = super.save(order);
        this.orderValueRepository.save(new OrderValue(order));
        return order;
    }
}
