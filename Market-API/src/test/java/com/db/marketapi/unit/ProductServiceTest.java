package com.db.marketapi.unit;

import com.db.marketapi.model.Cart;
import com.db.marketapi.model.Product;
import com.db.marketapi.model.User;
import com.db.marketapi.service.CartService;
import com.db.marketapi.service.ProductService;
import com.db.marketapi.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional
public class ProductServiceTest {
  @Autowired ProductService productService;
  @Autowired CartService cartService;
  @Autowired UserService userService;

  @Test
  public void givenProduct_WhenAddedToCart_ThenCheckIfExistInCart() {
    Product product = new Product();
    product.setPrice(0.0);
    product.setPrice(69.0);
    product.setProductCode(1234L);
    product.setProductDescription(" ");

    Cart cart = new Cart();
    cart.setProducts(new ArrayList<Product>());
    cart.setCartTotalProductsNo(0);
    cart.setCartTotalPrice(0.0);

    User user = new User();
    userService.createUser(user);

    cartService.createCartForUser(cart, user.getId());
    System.err.println(cart);
    System.err.println(user);
    productService.addProductToUserCart(user.getId(), product);

    boolean result = false;
    for (Product prod : user.getCart().getProducts()) {
      if (prod.equals(product)) {
        result = true;
      }
    }
    Assertions.assertTrue(result);
  }
}
