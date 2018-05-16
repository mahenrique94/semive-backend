package br.com.matheuscastiglioni.semivebackend.domain.order.item;

import br.com.matheuscastiglioni.semivebackend.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByIdOrder(Order order);

}
