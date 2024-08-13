package com.ghrairi.TounsiKids.services;

import com.ghrairi.TounsiKids.models.Product;
import com.ghrairi.TounsiKids.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
           return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(Product product,Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            return productRepository.save(updatedProduct);

        }
        else {
            throw new RuntimeException("Produit non trouvée avec l'ID : " + id);        }
    }

}
