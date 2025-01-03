package com.ecommerce.productservicenovermber2024.repositories;

import com.ecommerce.productservicenovermber2024.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

     List<Product> findProductByPriceGreaterThan(Double price);

    List<Product> findProductByTitleLike(String title);

//    List<Product> findProductByTitleLike(int top,String title);

    List<Product>findByPriceBetween(Double price1, Double price2);


    Optional<Product> findById(Long productId);

    void deleteById(Long productId);
}
