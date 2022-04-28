package com.db.marketapi.controller;

import com.db.marketapi.model.*;
import com.db.marketapi.service.CartService;
import com.db.marketapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart")
public class CartController {

  private final CartService cartService;
  private final UserService userService;

  @PostMapping("create/{userId}")
  public Cart createCartForUser(@RequestBody Cart cart, @PathVariable Long userId) {
    return cartService.createCartForUser(cart, userId);
  }

  @PostMapping("update")
  public Cart updateCart(@RequestBody Cart cart) {
    return cartService.updateCart(cart);
  }

  @DeleteMapping("delete/{id}/{userId}")
  public void deleteCartByIdForUser(@PathVariable Long id, @PathVariable Long userId) {
    cartService.deleteCartByIdForUser(id, userId);
  }

  @PostMapping("validate-cart/{userId}")
  public User processCartMakeOrders(@PathVariable Long userId, @RequestBody Order order) {
    return cartService.processCartMakeOrders(userId, order);
  }

  @GetMapping("get-carts-sorted-ProdTotal")
  public List<Cart> getAllCartsFromUsersSortedByProdTotal() {
    return cartService.getAllCartsFromUsersSortedByProdTotal();
  }

  @GetMapping("/{id}")
  public Optional<Cart> getCartById(@PathVariable Long id) {
    return cartService.getCartById(id);
  }

  @GetMapping("/all")
  public List<Cart> getAllCarts() {
    return cartService.getAllCarts();
  }

  @GetMapping("/all-by-prodNo")
  public List<Cart> getAllCartsByTotalProdNo() {
    return cartService.getAllCartsByTotalProdNo();
  }
}
