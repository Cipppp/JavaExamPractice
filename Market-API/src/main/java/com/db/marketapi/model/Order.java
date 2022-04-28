package com.db.marketapi.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders_table")
@Data
public class Order implements Comparable<Order> {
  @Id
  @Column(name = "order_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long orderId;

  private Date orderDate;
  private Date shippedDate;
  private String productDetails;

  @Override
  public int compareTo(@NotNull Order o) {
    return this.getOrderDate().compareTo(o.getOrderDate());
  }
}
