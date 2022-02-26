package com.company.ecommerce.cart.controller;

import com.company.ecommerce.cart.service.CartDuplicateException;
import com.company.ecommerce.product.controller.ProductErrorResponse;
import com.company.ecommerce.product.service.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CartControllerAdvice {

    @ExceptionHandler(CartDuplicateException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CartErrorResponse cartDuplicate(CartDuplicateException e){
        return new CartErrorResponse("Product Id="+e.getMessage()+" duplicate in cart.");
    }

}
