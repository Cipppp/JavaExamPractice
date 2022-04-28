package com.db.marketapi.service;

import com.db.marketapi.model.Order;
import com.db.marketapi.model.User;
import com.db.marketapi.repository.OrderRepository;
import com.db.marketapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  public void deleteOrderFromUserOrderHistory(Long userId, Long id) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Order> order = orderRepository.findById(id);

    if (user.isPresent()) {
      user.get().getOrderHistory().remove(order.get());
      orderRepository.deleteById(id);
    }
  }

  public Order updateOrder(Order order) {
    return orderRepository.save(order);
  }

  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  public Optional<Order> getOrderById(Long id) {
    return orderRepository.findById(id);
  }
}
