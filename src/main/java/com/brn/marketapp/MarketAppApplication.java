package com.brn.marketapp;

import com.brn.marketapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class MarketAppApplication{

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(MarketAppApplication.class, args);
	}
}
