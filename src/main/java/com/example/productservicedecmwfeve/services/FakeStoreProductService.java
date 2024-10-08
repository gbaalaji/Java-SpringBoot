package com.example.productservicedecmwfeve.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.example.productservicedecmwfeve.models.Category;
import com.example.productservicedecmwfeve.models.Product;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct){
        Product product = new Product();
        product.setTitle((fakeStoreProduct.getTitle()));
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;

    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException{
        // int i = 1/0;
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, 
        FakeStoreProductDto.class);
        // return convertFakeStoreProductToProduct(productDto);
        if (productDto == null){
            throw new ProductNotExistsException(
                "Product with id: " + id + " doesn't exist."
            );
        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @SuppressWarnings("null")
    @Override
    public List<Product> getAllProducts() {



//        List<FakeStoreProductDto> response = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                List<FakeStoreProductDto>.class
//        );

        // runtime
        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );


        List<Product> answer = new ArrayList<>();


        for (FakeStoreProductDto dto: response) {
            answer.add(convertFakeStoreProductToProduct(dto));
        }

        return answer;
    }

    @Override
    public Product replaceProduct(Long id, Product product){
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class );
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        
        return convertFakeStoreProductToProduct(response);
    }
    
}
