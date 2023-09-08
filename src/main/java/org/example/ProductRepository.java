package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public Product saveProduct(Product product) {
        products.add(product);
        return product;
    }

    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product updateProduct(Product product) {
        for (Product updatedProduct : products) {
            if (updatedProduct.getId().equals(product.getId())) {
                updatedProduct.setName(product.getName());
                updatedProduct.setPrice(product.getPrice());
                updatedProduct.setCategory(product.getCategory());
                return updatedProduct;
            }
        }
        return null;
    }


    public void removeProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                return;
            }
        }
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByMinRating(int minRating) {
        return products.stream()
                .filter(product -> product.getRating() >= minRating)
                .toList();
    }
}

