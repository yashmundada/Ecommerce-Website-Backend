package com.ecommerce.productservicenovermber2024.inheritanceTypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="2")
public class Mentor extends User {
    private String Company;

}
