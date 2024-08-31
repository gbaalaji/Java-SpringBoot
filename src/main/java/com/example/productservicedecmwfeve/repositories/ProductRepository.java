package com.example.productservicedecmwfeve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productservicedecmwfeve.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
