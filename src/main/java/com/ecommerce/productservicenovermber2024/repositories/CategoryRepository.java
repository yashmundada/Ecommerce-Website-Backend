package com.ecommerce.productservicenovermber2024.repositories;

import com.ecommerce.productservicenovermber2024.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Override
    Category save(Category category);
}
