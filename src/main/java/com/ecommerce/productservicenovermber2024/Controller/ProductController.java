package com.ecommerce.productservicenovermber2024.Controller;
import com.ecommerce.productservicenovermber2024.Models.Product;
import com.ecommerce.productservicenovermber2024.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                           //Restcontroller tells spring that this is a special class.
@RequestMapping("/Product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //get  product with id
    @GetMapping("/{id}")
    public Product getproductByID(@PathVariable("id")Long id) {
          return productService.getSingleProduct(id);
    }

    //get all products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

     @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id")Long id, @RequestBody Product product) {
        return productService.replaceProduct(id,product);
     }

     @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")Long id, @RequestBody Product product) {
        return productService.updateProduct(id,product);
    }





}
