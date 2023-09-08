package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();

        // Beispiel Builder
        Product product1 = Product.builder()
                .id("12")
                .name("Product 1")
                .price(999)
                .category("Cat 1")
                .build();


        Product product2 = new Product();
        product2.setId("12341");
        product2.setName("Product 2");
        product2.setPrice(299);
        product2.setCategory("Category 2");
        product2.setRating(3);

        repository.saveProduct(product1);
        repository.saveProduct(product2);


        List<Product> products = repository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }


        int minRating = 4;
        List<Product> highRatedProducts = repository.findByMinRating(minRating);

        System.out.println("Produkte mit einer Mindestbewertung von " + minRating + ":");
        for (Product product : highRatedProducts) {
            System.out.println(product);
        }
    }

}
