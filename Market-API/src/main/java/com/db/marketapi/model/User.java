package com.db.marketapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
  @Id
  @Column(name = "user_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;

  private Integer numOfOrders;

  @OneToOne private Cart cart;

  @OneToOne private WishList wishlist;

  @OneToMany(cascade = CascadeType.ALL)
  List<Order> orderHistory;
}
