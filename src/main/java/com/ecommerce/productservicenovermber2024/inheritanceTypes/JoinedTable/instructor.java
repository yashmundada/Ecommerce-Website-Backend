package com.ecommerce.productservicenovermber2024.inheritanceTypes.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class instructor extends User {
    private  String module;


}
