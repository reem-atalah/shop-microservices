package com.example.bookingMicroservice.controller;

import com.example.bookingMicroservice.client.stockClient;
import com.example.bookingMicroservice.dto.orderDTO;
import com.example.bookingMicroservice.entity.order;
import com.example.bookingMicroservice.repository.bookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookingMicroservice.client.stockClient;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class bookingController {

    @Autowired
    bookingRepository orderRepo;

    @Autowired
    private stockClient stockClient;

    @PostMapping("/order")
    public String order(@RequestBody orderDTO orderDto){

//        check first if order are ready in the company storage/stock
        boolean inStock = orderDto.getOrderItems().stream()
                .allMatch(orderItem->stockClient.stockCheck(orderItem.getCode()));
        if(inStock) {
            order order = new order();
            order.setOrderNo(UUID.randomUUID().toString());
            order.setOrderItems(orderDto.getOrderItems());
            orderRepo.save(order);
            return "Order placed successfully";
        }
        else{
            return "Order can't be placed";
        }
    }

}
