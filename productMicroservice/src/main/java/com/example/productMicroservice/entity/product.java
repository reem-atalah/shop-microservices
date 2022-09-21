package com.example.productMicroservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Document: use it to map a Java class into a collection inside MongoDB.
@Document(value= "product")
@Getter
@Setter
@NoArgsConstructor
public class product {
    @Id
    private String id;
    private String productName;
    private String productDescription;
    private Double perUnitPrice;
}
