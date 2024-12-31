package com.ecommerce.productservicenovermber2024.inheritanceTypes.Singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value="0")
public class User {
    @Id
    private int id;
    private String mail;
    private String name;

}
