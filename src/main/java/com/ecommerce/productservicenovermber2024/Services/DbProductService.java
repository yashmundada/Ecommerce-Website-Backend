package com.ecommerce.productservicenovermber2024.Services;

import com.ecommerce.productservicenovermber2024.Exception.ProductNotFoundException;
import com.ecommerce.productservicenovermber2024.Models.Category;
import com.ecommerce.productservicenovermber2024.Models.Product;
import com.ecommerce.productservicenovermber2024.repositories.CategoryRepository;
import com.ecommerce.productservicenovermber2024.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class DbProductService implements ProductService {

    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public DbProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public Product getSingleProduct(Long productId)  {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
             throw new ProductNotFoundException("Product with id " +productId+"does not exist" );
        }
        return  optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
         return productRepository.findAll();

    }

    @Override
    public Product updateProduct(Long product_id, Product product) throws ProductNotFoundException {
        Optional<Product>productOptional=productRepository.findById(product_id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id " +product_id+"does not exist" );
        }

        Product productInDb=productOptional.get();
        if(product.getTitle()!=null){
            productInDb.setTitle(product.getTitle());
        }
        if(product.getPrice()!=null){
            productInDb.setPrice(product.getPrice());
        }
        return productRepository.save(productInDb);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {

            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isEmpty()) {
                throw new ProductNotFoundException("Product with id " + id + "does not exist");

            }
            Product productInDb = productOptional.get();
            productInDb.setUpdatedAt(product.getUpdatedAt());
            productInDb.setCreatedAt(product.getCreatedAt());
            productInDb.setTitle(product.getTitle());
            productInDb.setPrice(product.getPrice());
            Optional<Category> categoryOptional = categoryRepository.findById(Integer.valueOf(String.valueOf(productInDb.getCategory().getId())));
            Category category = new Category();
            category.setName(product.getCategory().getName());
            category.setDescription(product.getCategory().getDescription());
            productInDb.setCategory(categoryRepository.save(category));
            return productRepository.save(productInDb);
        }



        @Override
        public void deleteSingleProduct(Long product_id) throws ProductNotFoundException {
        Optional<Product>productOptional=productRepository.findById(product_id);
        if(productOptional.isEmpty()){
         throw new ProductNotFoundException("Product with id " +product_id+"does not exist" );
     }
         //productRepository.deleteById(product_id);
        productRepository.delete(productOptional.get());
    }

    @Override
    public Product addNewProduct(Product product) {
    Category category=product.getCategory();
    if(category.getId()==null){
        category=categoryRepository.save(category);
        product.setCategory(category);

    }
    return productRepository.save(product);
    }


}


