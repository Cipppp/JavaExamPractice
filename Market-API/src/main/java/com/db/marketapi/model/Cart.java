package com.db.marketapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {
  @Id
  @Column(name = "cart_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long cartId;

  private Double cartTotalPrice;
  private Integer cartTotalProductsNo;

  @OneToOne User user;

  @OneToMany(fetch = FetchType.EAGER)
  List<Product> products;
}
