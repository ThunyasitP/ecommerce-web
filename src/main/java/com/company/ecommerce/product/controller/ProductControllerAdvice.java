package com.company.ecommerce.product.controller;

import com.company.ecommerce.product.service.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProductErrorResponse productNotFound(ProductNotFoundException e){
        return new ProductErrorResponse("Product Id="+e.getMessage()+" not found.");
    }

}
