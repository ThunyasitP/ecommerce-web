package com.company.ecommerce.cart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, CartKey> {

    @Modifying
    @Query(value = "INSERT INTO cart ( member_id, product_id, total ) VALUES ( :memberId, :productId, :total )", nativeQuery = true)
    void insertCart(@Param("memberId") int memberId, @Param("productId") int productId, @Param("total") int total);


    @Query(value = "SELECT c.* FROM cart c WHERE c.member_id = :memberId AND c.product_id = :productId ", nativeQuery = true)
    Optional<Cart> findCartsWithMemberAndProduct(@Param("memberId") int memberId, @Param("productId") int productId);

    List<Cart> findAll();


}
