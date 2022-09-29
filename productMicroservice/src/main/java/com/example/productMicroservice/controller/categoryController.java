package com.example.productMicroservice.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//for refresh scope
@RestController
@RequestMapping("/api/products/categories")
@Getter
@Setter
@RefreshScope //this will refresh all the @Value data in this bean
              // when /actuator/refresh is called. refresh is actuator
public class categoryController {

    @Value("${app.prop1}")
    private String prop1;

    @GetMapping("/prop")
    public String getProp1() {
        return this.prop1;
    }
}
