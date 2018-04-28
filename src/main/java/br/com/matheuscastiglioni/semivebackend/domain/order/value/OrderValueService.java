package br.com.matheuscastiglioni.semivebackend.domain.order.value;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class OrderValueService extends GenericService<OrderValue, OrderValueRepository, Long> {

    public OrderValueService(OrderValueRepository repository) {
        super(repository);
    }

}
