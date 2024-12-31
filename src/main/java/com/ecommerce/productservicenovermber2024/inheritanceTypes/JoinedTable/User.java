package com.ecommerce.productservicenovermber2024.inheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_users")
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
    @Id
    private int id;
    private String mail;
    private String name;

}
