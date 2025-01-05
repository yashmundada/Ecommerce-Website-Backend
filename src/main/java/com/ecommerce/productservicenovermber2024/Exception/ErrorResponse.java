package com.ecommerce.productservicenovermber2024.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String  message;
    private boolean  success;
    private HttpStatus  status;
}
