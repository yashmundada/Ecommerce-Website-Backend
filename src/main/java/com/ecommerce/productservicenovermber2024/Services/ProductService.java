package com.ecommerce.productservicenovermber2024.Services;

import com.ecommerce.productservicenovermber2024.Models.Product;

import java.util.List;

public interface ProductService {

     Product getSingleProduct(Long productId);

     List<Product> getAllProducts();

     Product updateProduct(Long id, Product product);

     Product replaceProduct(Long id, Product product);
}
