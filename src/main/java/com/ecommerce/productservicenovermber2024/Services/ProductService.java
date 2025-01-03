package com.ecommerce.productservicenovermber2024.Services;

import com.ecommerce.productservicenovermber2024.Exception.ProductNotFoundException;
import com.ecommerce.productservicenovermber2024.Models.Product;

import java.util.List;

public interface ProductService {

     Product getSingleProduct(Long productId) throws ProductNotFoundException;

     List<Product> getAllProducts();

     Product updateProduct(Long id, Product product) throws ProductNotFoundException;

     Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

     void deleteSingleProduct(Long id) throws ProductNotFoundException;

}
