package com.db.marketapi.unit;

import com.db.marketapi.model.Cart;
import com.db.marketapi.model.User;
import com.db.marketapi.service.CartService;
import com.db.marketapi.service.UserService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
@Transactional
public class CartServiceTest {
  @Autowired CartService cartService;
  @Autowired UserService userService;

  @Test
  public void whenCreateCartForUser_ThenUserCartDiffersFromNull() {
    User user = new User();

    userService.createUser(user);

    Cart cart = new Cart();

    cartService.createCartForUser(cart, user.getId());

    Assertions.assertNotNull(user.getCart());
  }

  @Test
  public void whenDeleteCartForUser_ThenUserCartEqualsNull() {
    User user = new User();

    userService.createUser(user);

    Cart cart = new Cart();

    cartService.createCartForUser(cart, user.getId());
    cartService.deleteCartByIdForUser(cart.getCartId(), user.getId());

    Assertions.assertNull(user.getCart());
  }
}
