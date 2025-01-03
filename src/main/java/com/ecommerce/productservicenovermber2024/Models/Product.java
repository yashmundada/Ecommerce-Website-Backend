package com.ecommerce.productservicenovermber2024.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
     private String title;
     private Double price;
     @ManyToOne
     private Category category;

}


 //1        1
//product category
//m         1            ..many to one