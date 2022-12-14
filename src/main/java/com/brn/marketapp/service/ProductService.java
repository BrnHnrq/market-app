package com.brn.marketapp.service;

import com.brn.marketapp.entity.Product;
import com.brn.marketapp.enums.CategoryEnum;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductService {
    Product get(UUID id);
    List<Product> getAll();
    void remove(UUID id);
    Product save(Product product);
    List<CategoryEnum> getCategories();
}
