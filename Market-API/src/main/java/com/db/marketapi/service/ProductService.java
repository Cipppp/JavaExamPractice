package com.db.marketapi.service;

import com.db.marketapi.model.Product;
import com.db.marketapi.model.User;
import com.db.marketapi.model.WishList;
import com.db.marketapi.repository.ProductRepository;
import com.db.marketapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final UserRepository userRepository;

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProductById(Long id) {
    productRepository.deleteById(id);
  }

  public Product addProductToUserCart(Long userId, Product product) {
    Optional<User> user = userRepository.findById(userId);

    if (user.isPresent()) {
      user.get().getCart().getProducts().add(product);
      user.get()
          .getCart()
          .setCartTotalPrice(user.get().getCart().getCartTotalPrice() + product.getPrice());
      user.get()
          .getCart()
          .setCartTotalProductsNo(user.get().getCart().getCartTotalProductsNo() + 1);
    }
    return productRepository.save(product);
  }

  public Product addProductToWishList(Long userId, Long productId) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Product> product = productRepository.findById(productId);

    if (user.isPresent() && product.isPresent()) {
      WishList wishList = user.get().getWishlist();
      wishList.getDesiredProducts().add(product.get());
      user.get().setWishlist(wishList);
    }

    return product.get();
  }

  public void deleteProductFromUserCart(Long userId, Long productId) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Product> product = productRepository.findById(productId);

    if (user.isPresent() && product.isPresent()) {
      user.get().getCart().getProducts().remove(product.get());
      productRepository.deleteById(productId);
    }
  }

  public void deleteProductFromWishList(Long userId, Long productId) {
    Optional<User> user = userRepository.findById(userId);
    Optional<Product> product = productRepository.findById(productId);

    if (user.isPresent() && product.isPresent()) {
      user.get().getWishlist().getDesiredProducts().remove(product);
      productRepository.deleteById(productId);
    }
  }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }
}
