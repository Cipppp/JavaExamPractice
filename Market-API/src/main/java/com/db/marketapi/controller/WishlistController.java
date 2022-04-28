package com.db.marketapi.controller;

import com.db.marketapi.model.WishList;
import com.db.marketapi.service.UserService;
import com.db.marketapi.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("wishlist")
public class WishlistController {
  private final WishlistService wishlistService;
  private final UserService userService;

  @PostMapping("create")
  public WishList createWishlist(@RequestBody WishList Wishlist) {
    return wishlistService.createWishlist(Wishlist);
  }

  @PostMapping("create-wish/{userId}")
  public WishList createWishListForUser(@RequestBody WishList wishlist, @PathVariable Long userId) {
    return wishlistService.createWishlistForUser(wishlist, userId);
  }

  @PostMapping("update")
  public WishList updateWishlist(@RequestBody WishList wishlist) {
    return wishlistService.updateWishList(wishlist);
  }

  @DeleteMapping("delete/{id}/{userId}")
  public void deleteWishlistByIdForUser(@PathVariable Long id, @PathVariable Long userId) {
    wishlistService.deleteWishListByIdForUser(id, userId);
  }

  @GetMapping("/{id}")
  public Optional<WishList> getWishlistById(@PathVariable Long id) {
    return wishlistService.getWishListById(id);
  }

  @GetMapping("/all")
  public List<WishList> getAllWishlists() {
    return wishlistService.getAllWishLists();
  }
}
