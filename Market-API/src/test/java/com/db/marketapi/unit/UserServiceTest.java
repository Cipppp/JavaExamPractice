package com.db.marketapi.unit;

import com.db.marketapi.model.Order;
import com.db.marketapi.model.User;
import com.db.marketapi.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {
  @Autowired UserService userService;

  @Test
  public void whenCreateUser_ThenReturnDiffersNull() {
    User user = new User();

    Assertions.assertNotNull(userService.createUser(user));
  }
}
