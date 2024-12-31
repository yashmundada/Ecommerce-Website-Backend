package com.ecommerce.productservicenovermber2024.inheritanceTypes.TablePerClass;

import com.ecommerce.productservicenovermber2024.inheritanceTypes.JoinedTable.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class instructor extends User {
    private  String module;


}
