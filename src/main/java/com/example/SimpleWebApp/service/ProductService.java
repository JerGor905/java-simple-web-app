package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(new Product(69, "No such item", 420));
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getId() == prod.getId())
                .findFirst()
                .orElse(-1);

        if (index != -1) products.set(index, prod);
    }

    public void deleteProductById(int id) {
        int index = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        if (index != -1) products.remove(index);
    }
}
