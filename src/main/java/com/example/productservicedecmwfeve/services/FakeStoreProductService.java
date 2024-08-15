package com.example.productservicedecmwfeve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.example.productservicedecmwfeve.models.Category;
import com.example.productservicedecmwfeve.models.Product;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
        Product product = new Product();
        product.setTitle((fakeStoreProduct.getTitle()));
        product.setIdLong(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;

    }

    @Override
    public Product getSingleProduct(Long idlong){
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+idlong, 
        FakeStoreProductDto.class);
        return convertFakeStoreProductToProduct(productDto);
    }
    
}
