package com.brn.marketapp.controller;

import com.brn.marketapp.entity.Product;
import com.brn.marketapp.enums.CategoryEnum;
import com.brn.marketapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products/{id}")
    ResponseEntity<Object> getSingleProduct(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.get(id));
    }

    @GetMapping("/products")
    ResponseEntity<Object> getProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @PostMapping("/products")
    ResponseEntity<Object> saveProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(product));
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<Object> deleteProduct(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @PutMapping("/products")
    ResponseEntity<Object> updateProduct(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(product));
    }
}
