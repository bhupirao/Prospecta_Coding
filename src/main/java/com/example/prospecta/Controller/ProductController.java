package com.example.prospecta.Controller;


import com.example.prospecta.Model.Product;
import com.example.prospecta.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Task 1: Fetch products by category
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    // Task 2: Add a new product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
