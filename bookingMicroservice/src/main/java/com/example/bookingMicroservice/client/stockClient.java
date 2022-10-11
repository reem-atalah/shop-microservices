package com.example.bookingMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// exact name written in bootstrap.properties in stock-service
// it's called from eureka server
@FeignClient(name = "stock-service")
public interface stockClient {

//     call the same get request in controller of stock service
    @GetMapping("/api/stock/{code}")
    boolean stockCheck(@PathVariable String code);
}
