package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "AE86", 238000),
                    new Product(2, "FD3S", 268000),
                    new Product(3, "BNR32", 448000)
            )
    );

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(new Product(0, "No such item", 0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
