package com.company.ecommerce.product.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p")
    List<Product> findAllProducts();

    @Query(value = "SELECT p FROM Product p WHERE ( p.name LIKE %:product% OR LOWER(p.name) LIKE %:product% ) AND ( p.name <> '' AND  p.name IS NOT NULL AND LEN(p.name) > 0 ) " )
    List<Product> findProductByName( @Param("product")  String product);

    @Query(value = "SELECT p FROM Product p WHERE p.id = :id")
    List<Product> findProductById( @Param("id")  int id);

}
