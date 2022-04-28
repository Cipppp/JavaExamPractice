package com.db.marketapi.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
  @Id
  @Column(name = "product_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;

  private Long productCode;
  private String productDescription;
  private Double price;

  @ManyToOne(cascade = CascadeType.ALL)
  Cart cart;

  @ManyToOne(cascade = CascadeType.ALL)
  WishList wishlist;
}
