package com.db.marketapi.service;

import com.db.marketapi.model.Cart;
import com.db.marketapi.model.Order;
import com.db.marketapi.model.Product;
import com.db.marketapi.model.User;
import com.db.marketapi.repository.CartRepository;
import com.db.marketapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
  private final CartRepository cartRepository;
  private final UserRepository userRepository;

  public Cart createCartForUser(Cart cart, Long userId) {
    Optional<User> optUser = userRepository.findById(userId);
    if (optUser.isPresent()) {
      User user = optUser.get();
      user.setCart(cart);
      return cartRepository.save(cart);
    }
    return null;
  }

  public void deleteCartByIdForUser(Long id, Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      user.get().setCart(null);
      cartRepository.deleteById(id);
    }
  }

  /*
  Pentru fiecare produs din cart cream un order nou. Primin un JSON care va contine
  ordered date -> date-ul actual, iar restul campuriilor null deoarece vor fi completate
  in viitor.
   */
  public User processCartMakeOrders(Long userId, Order order) {

    Optional<User> userOpt = userRepository.findById(userId);
    if (userOpt.isPresent()) {
      User user = userOpt.get();
      if (user.getCart().getProducts().size() > 0) {
        for (Product product : user.getCart().getProducts()) {
          order.setProductDetails(product.getProductDescription());
          user.getOrderHistory().add(order);
          user.getOrderHistory()
              .sort(
                  new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                      return o1.getOrderDate().compareTo(o2.getOrderDate());
                    }
                  });
          if (user.getNumOfOrders() != null) {
            user.setNumOfOrders(user.getNumOfOrders() + 1);
          }
        }
      }
      return user;
    }
    return null;
  }

  public List<Cart> getAllCartsFromUsersSortedByProdTotal() {
    return cartRepository.findByOrderByCartTotalProductsNoDesc();
  }

  public Cart updateCart(Cart cart) {
    return cartRepository.save(cart);
  }

  public List<Cart> getAllCarts() {
    return cartRepository.findAll();
  }

  public Optional<Cart> getCartById(Long id) {
    return cartRepository.findById(id);
  }

  public List<Cart> getAllCartsByTotalProdNo() {
    return cartRepository.findByOrderByCartTotalProductsNoDesc();
  }
}
