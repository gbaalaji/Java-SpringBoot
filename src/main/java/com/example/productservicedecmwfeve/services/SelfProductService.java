package com.example.productservicedecmwfeve.services;

import java.util.List;

// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.example.productservicedecmwfeve.models.Product;
import com.example.productservicedecmwfeve.repositories.CategoryRepository;
import com.example.productservicedecmwfeve.repositories.ProductRepository;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                            CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSingleProduct'");
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceProduct'");
    }
    
}
