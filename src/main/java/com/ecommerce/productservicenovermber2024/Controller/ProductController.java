package com.ecommerce.productservicenovermber2024.Controller;
import com.ecommerce.productservicenovermber2024.Exception.ProductNotFoundException;
import com.ecommerce.productservicenovermber2024.Models.Product;
import com.ecommerce.productservicenovermber2024.Services.ProductService;
import com.ecommerce.productservicenovermber2024.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                           //Restcontroller tells spring that this is a special class.
@RequestMapping("/Product")
public class ProductController {

    private final ProductRepository productRepository;
    ProductService productService;

    public ProductController(@Qualifier("dbProductService") ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


    //get  product with id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductByID(@PathVariable("id")Long id) throws ProductNotFoundException {
        ResponseEntity<Product> responseEntity=new ResponseEntity<>(
                productService.getSingleProduct(id),
                 HttpStatus.OK
        );
          return responseEntity;

    }

    //get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> responseEntity=new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
        return responseEntity;

    }
    //Create the new Product
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
       return productService.addNewProduct(product);
    }

    //delete product with id
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id")Long id) throws ProductNotFoundException {
        productService.deleteSingleProduct(id);
        return "Product deleted successfully";
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id")Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(id,product);
     }

     @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id,product);
    }


}
