package com.example.prospecta.Service;

import com.example.prospecta.Model.Product;
import com.example.prospecta.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Value("${external.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    // Task 1: Fetch products by category
    public List<Product> getProductsByCategory(String category) {
        String url = apiUrl + "/products/category/" + category;
        try {
            Product[] products = restTemplate.getForObject(url, Product[].class);
            if (products != null) {
                // Optionally save to the database
                for (Product product : products) {
                    productRepository.save(product);
                }
                return Arrays.asList(products);
            } else {
                throw new RuntimeException("No products found for category: " + category);
            }
        } catch (HttpStatusCodeException e) {
            throw new RuntimeException("Error fetching products from external API: " + e.getMessage());
        }
    }

    // Task 2: Add a new product using Fake Store API
    public Product addProduct(Product product) {
        String url = apiUrl + "/products";
        try {
            Product createdProduct = restTemplate.postForObject(url, product, Product.class);
            if (createdProduct != null) {
                // Optionally save the created product to the local database
                return productRepository.save(createdProduct);
            } else {
                throw new RuntimeException("Failed to create product via external API.");
            }
        } catch (HttpStatusCodeException e) {
            throw new RuntimeException("Error adding product to external API: " + e.getMessage());
        }
    }
}
