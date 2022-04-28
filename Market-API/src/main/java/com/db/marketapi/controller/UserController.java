package com.db.marketapi.controller;

import com.db.marketapi.model.*;
import com.db.marketapi.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
  private final UserService userService;

  @PostMapping("create")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PostMapping("update")
  public User updateUser(@RequestBody User user) {
    return userService.updateUser(user);
  }

  @GetMapping("get-users-sorted-numOrders")
  public List<User> getAllUsersSortedByNumOfOrders() {
    return userService.getAllUsersSortedByNumOfOrders();
  }

  @DeleteMapping("delete/{id}")
  public void deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
  }

  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("/all")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
