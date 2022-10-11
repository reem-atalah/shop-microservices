package com.example.bookingMicroservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.PrivateKey;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private BigDecimal price;
    private Integer orderQty;
}
