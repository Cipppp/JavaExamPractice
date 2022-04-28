package com.db.marketapi.unit;

import com.db.marketapi.model.Order;
import com.db.marketapi.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class OrderServiceTest {
  @Autowired OrderService orderService;

  @Test
  public void whenCreateOrder_ThenReturnDiffersNull() {
    Order order = new Order();

    Assertions.assertNotNull(orderService.createOrder(order));
  }

}
