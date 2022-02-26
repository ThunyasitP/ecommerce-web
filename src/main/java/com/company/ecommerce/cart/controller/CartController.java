package com.company.ecommerce.cart.controller;

import com.company.ecommerce.cart.service.CartService;
import com.company.ecommerce.product.controller.ProductResponse;
import com.company.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/carts")
    public CartResponse addProductToCart(@RequestBody CartRequestAddCart requestAddCart){
        cartService.addProductToCart(requestAddCart.getMember_id(), requestAddCart.getProduct_id(), requestAddCart.getTotal());
        return new CartResponse(requestAddCart.getProduct_id(), requestAddCart.getTotal());
    }


    @GetMapping("/carts/{memberId}")
    public List<CartResponse> getProductInCart(@PathVariable int memberId){
        List<CartResponse> responses = cartService.findCartByMember(memberId);
        return responses;
    }

}
