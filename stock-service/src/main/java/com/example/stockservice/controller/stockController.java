package com.example.stockservice.controller;

import com.example.stockservice.entity.stockEntity;
import com.example.stockservice.repository.stockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class stockController {

    @Autowired
    private stockRepository stockRepo;

    @GetMapping("/{code}")
    public boolean stockAvailable(@PathVariable String code){

        Optional<stockEntity> opStock= stockRepo.findByCode(code);
        opStock.orElseThrow(()-> new RuntimeException("Can't find the product"));

        return opStock.get().getQuantity() > 0;
    }
}
