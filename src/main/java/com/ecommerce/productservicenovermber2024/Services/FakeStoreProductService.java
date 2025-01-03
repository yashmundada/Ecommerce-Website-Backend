package com.ecommerce.productservicenovermber2024.Services;

import com.ecommerce.productservicenovermber2024.Exception.ProductNotFoundException;
import com.ecommerce.productservicenovermber2024.Models.Category;
import com.ecommerce.productservicenovermber2024.Models.Product;
import com.ecommerce.productservicenovermber2024.Dtos.FakeStoreDto;
import com.ecommerce.productservicenovermber2024.repositories.ProductRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
@Service("fakeStoreproductService")
public class FakeStoreProductService implements ProductService {
    private final ProductRepository productRepository;
    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, ProductRepository productRepository) {
        this.restTemplate = restTemplate;
        this.productRepository = productRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreDto fakeStoreDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+productId, FakeStoreDto.class);
          return convertFakeStoreDtoToProduct(fakeStoreDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreDto[] fakeStoreDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreDto[].class);

        List<Product>products=new ArrayList<>();
        for(FakeStoreDto fakeStoreDto:fakeStoreDtos){
            products.add(convertFakeStoreDtoToProduct(fakeStoreDto));
        }
        return products;
    }



    void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreDto fakeStoreDto=restTemplate.patchForObject("https://fakestoreapi.com/products/"+id, product, FakeStoreDto.class);
        return convertFakeStoreDtoToProduct(fakeStoreDto);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        ResponseEntity<FakeStoreDto> response = restTemplate.exchange( "https://fakestoreapi.com/products/" + id, HttpMethod.PUT, request,
                FakeStoreDto.class);
        return convertFakeStoreDtoToProduct(response.getBody());

    }

    @Override
    public void deleteSingleProduct(Long id) throws ProductNotFoundException {

    }


    private Product convertFakeStoreDtoToProduct(FakeStoreDto fakeStoreDto) {
        Product product = new Product();
        product.setId(fakeStoreDto.getId());

        Category category = new Category();
        category.setDescription(fakeStoreDto.getDescription());
        category.setName(fakeStoreDto.getCategory());

        product.setCategory(category);
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        return product;
    }
}
