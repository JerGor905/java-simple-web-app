package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = Arrays.asList(
            new Product(1, "AE86", 238000),
            new Product(2, "FD3S", 268000),
            new Product(3, "BNR32", 448000)
    );

    public List<Product> getProducts() {
        return products;
    }

}
