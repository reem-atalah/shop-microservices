package com.example.productMicroservice.repository;

import com.example.productMicroservice.entity.product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepository extends MongoRepository<product, String> {

}
