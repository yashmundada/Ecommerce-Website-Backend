package com.ecommerce.productservicenovermber2024.Services;

import com.ecommerce.productservicenovermber2024.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DbProductService implements ProductService {
    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}


