package com.example.productservicedecmwfeve.services;

import java.util.List;

import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.example.productservicedecmwfeve.models.Product;

public interface ProductService {
    Product getSingleProduct(Long idLong) throws ProductNotExistsException;
    List<Product> getAllProducts();
    Product replaceProduct(Long idLong, Product product);
    
}
