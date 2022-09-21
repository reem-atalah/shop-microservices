package com.example.productMicroservice.controller;

import com.example.productMicroservice.entity.product;
import com.example.productMicroservice.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {

    @Autowired
    private productRepository productRepo;

    @GetMapping
//    @ResponseStatus(HttpStatus.OK) // we need this if we don't put it in the method
//    response status
    public ResponseEntity< List<product> >getAllProducts(){
        List<product> Products= productRepo.findAll();
        ResponseEntity< List<product> > response = new ResponseEntity< List<product> >( Products, HttpStatus.OK);
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody product newProduct){
//        productRepo.insert(newProduct);
        productRepo.save(newProduct);
    }
}
