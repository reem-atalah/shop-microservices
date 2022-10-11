package com.example.bookingMicroservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderNo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<orderItem> orderItems;


}
