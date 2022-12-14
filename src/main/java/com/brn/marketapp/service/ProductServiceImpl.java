package com.brn.marketapp.service;

import com.brn.marketapp.entity.Product;
import com.brn.marketapp.enums.CategoryEnum;
import com.brn.marketapp.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product get(UUID id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void remove(UUID id) {
        productRepository.delete(get(id));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<CategoryEnum> getCategories() {
        return productRepository.getCategories();
    }
}
