package com.ecommerce.productservicenovermber2024.inheritanceTypes.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value="1")
public class instructor extends User {
    private String module;
}
