package com.brn.marketapp.repo;

import com.brn.marketapp.entity.Product;
import com.brn.marketapp.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = "select productType from Product")
    List<CategoryEnum> getCategories();
}
