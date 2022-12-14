package com.brn.marketapp.entity;

import com.brn.marketapp.enums.CategoryEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_brand", nullable = false, unique = true)
    private String productBrand;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_cost", nullable = false)
    private BigDecimal productCost;
    @Column(name = "product_quantity")
    private Long productQuantity;

    @Enumerated
    @Column(name = "product_type")
    private CategoryEnum productType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand.toLowerCase();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName.toLowerCase();
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CategoryEnum getProductType() {
        return productType;
    }

    public void setProductType(CategoryEnum productType) {
        this.productType = productType;
    }
}
