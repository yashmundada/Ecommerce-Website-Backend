package com.ecommerce.productservicenovermber2024.inheritanceTypes.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_student")
public class Student extends User {
   private double psp;

}
