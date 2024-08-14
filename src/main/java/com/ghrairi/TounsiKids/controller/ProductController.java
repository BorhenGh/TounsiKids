package com.ghrairi.TounsiKids.controller;

import com.ghrairi.TounsiKids.models.Product;
import com.ghrairi.TounsiKids.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import static com.ghrairi.TounsiKids.utils.Constants.Api_Root;
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(value = Api_Root+"product/All")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value = Api_Root+"product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping(value = Api_Root+"product/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping(value = Api_Root+"product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productDetails,id);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(value = Api_Root+"product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
