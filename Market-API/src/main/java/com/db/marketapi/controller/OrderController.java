package com.db.marketapi.controller;

import com.db.marketapi.model.Order;
import com.db.marketapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
  private final OrderService orderService;

  @PostMapping("create")
  public Order createOrder(@RequestBody Order order) {
    return orderService.createOrder(order);
  }

  @PostMapping("update")
  public Order updateOrder(@RequestBody Order order) {
    return orderService.updateOrder(order);
  }

  @DeleteMapping("delete/{userId}/{id}")
  public void deleteOrderFromUserOrderHistory(@PathVariable Long userId, @PathVariable Long id) {
    orderService.deleteOrderFromUserOrderHistory(userId, id);
  }

  @GetMapping("/{id}")
  public Optional<Order> getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }

  @GetMapping("/all")
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }
}
