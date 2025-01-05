package com.ecommerce.productservicenovermber2024.ControllerAdvice;

import com.ecommerce.productservicenovermber2024.Exception.ErrorResponse;
import com.ecommerce.productservicenovermber2024.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "Arithmetic exception from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException from GlobalExceptionHandler",
                HttpStatus.BAD_REQUEST
        );
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundExceptionException(ProductNotFoundException ex)
     {
     String message = ex.getMessage();
     ErrorResponse response = ErrorResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
     return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);


    }
}