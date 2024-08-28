package com.example.productservicedecmwfeve.services;

import java.util.List;

import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.example.productservicedecmwfeve.models.Product;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotExistsException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    
}
