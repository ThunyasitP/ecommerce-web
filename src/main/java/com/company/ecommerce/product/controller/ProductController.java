package com.company.ecommerce.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {

    @GetMapping("/products")
    public ArrayList<ProductResponse> getProductsAll(){
        ArrayList<ProductResponse> productResponses =  new ArrayList<ProductResponse>();
        productResponses.add(new ProductResponse(1, "1 Boy London T-shirt", "https://www.shutterstock.com/de/image-vector/california-ocean-side-stylish-tshirt-apparel-1180194466", 3500, 500, 50 ));
        productResponses.add(new ProductResponse(2, "2 Boy London T-shirt", "https://www.shutterstock.com/de/image-vector/california-ocean-side-stylish-tshirt-apparel-1180194466", 3500, 500, 50 ));
        productResponses.add(new ProductResponse(3, "3 Boy London T-shirt", "https://www.shutterstock.com/de/image-vector/california-ocean-side-stylish-tshirt-apparel-1180194466", 3500, 500, 50 ));
        productResponses.add(new ProductResponse(4, "4 Boy London T-shirt", "https://www.shutterstock.com/de/image-vector/california-ocean-side-stylish-tshirt-apparel-1180194466", 3500, 500, 50 ));
        return  productResponses;
    }
}
