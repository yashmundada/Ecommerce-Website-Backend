package com.ecommerce.productservicenovermber2024.inheritanceTypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="3")
public class Student extends User {
   private double psp;

}
