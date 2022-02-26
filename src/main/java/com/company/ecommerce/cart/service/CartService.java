package com.company.ecommerce.cart.service;

import com.company.ecommerce.cart.controller.CartResponse;
import com.company.ecommerce.cart.repository.Cart;
import com.company.ecommerce.cart.repository.CartRepository;
import com.company.ecommerce.product.controller.ProductResponse;
import com.company.ecommerce.product.repository.Product;
import com.company.ecommerce.product.repository.ProductRepository;
import com.company.ecommerce.product.service.ProductNotFoundException;
import com.company.ecommerce.product.service.ProductOutOfStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {


    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private CartResponse convertCartRepositoryToResponse(Cart cart) {
        return new CartResponse(
                cart.getProduct_id(),
                cart.getTotal());

    }


    @Transactional
    public void addProductToCart(int memberId, int productId, int total) {
        Optional<Cart> cartInfo = cartRepository.findCartsWithMemberAndProduct(memberId, productId);
        if (cartInfo.isPresent()) {
            throw new CartDuplicateException(productId);
        } else {
            Optional<Product> product = productRepository.findProductById(productId);
            if (product.isPresent()) {
                cartRepository.insertCart(memberId, productId, total);
                int stockAfterAddCart = (product.get().getTotal_stock() - total);
                if (stockAfterAddCart <= 0) {
                    throw new ProductOutOfStockException(productId);
                } else {
                    productRepository.updateTotalById(productId, stockAfterAddCart);
                }
            } else {
                throw new ProductNotFoundException(productId);
            }
        }
    }


    public List<CartResponse> findCartByMember(int memberId) {
        List<Cart> result = cartRepository.findCartsByMember(memberId);
        List<CartResponse> responses = new ArrayList<>();
        result.forEach(cart -> {
            responses.add(convertCartRepositoryToResponse(cart));
        });
        return responses;
    }


}
