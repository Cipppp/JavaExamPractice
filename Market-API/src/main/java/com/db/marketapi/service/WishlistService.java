package com.db.marketapi.service;

import com.db.marketapi.model.User;
import com.db.marketapi.model.WishList;
import com.db.marketapi.repository.UserRepository;
import com.db.marketapi.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistService {

  private final WishlistRepository wishlistRepository;
  private final UserRepository userRepository;

  public WishList createWishlist(WishList wishlist) {
    return wishlistRepository.save(wishlist);
  }

  public WishList createWishlistForUser(WishList wishlist, Long userId) {
    Optional<User> user = userRepository.findById(userId);
    if (user.isPresent()) {
      WishList newWishlist = wishlistRepository.save(wishlist);
      user.get().setWishlist(newWishlist);
      wishlistRepository.save(wishlist);
      userRepository.save(user.get());
      return newWishlist;
    }
    return null;
  }

  public void deleteWishListByIdForUser(Long id, Long userId) {
    Optional<User> user = userRepository.findById(userId);
    user.get().setWishlist(null);
    wishlistRepository.deleteById(id);
  }

  public WishList updateWishList(WishList wishlist) {
    return wishlistRepository.save(wishlist);
  }

  public List<WishList> getAllWishLists() {
    return wishlistRepository.findAll();
  }

  public Optional<WishList> getWishListById(Long id) {
    return wishlistRepository.findById(id);
  }
}
