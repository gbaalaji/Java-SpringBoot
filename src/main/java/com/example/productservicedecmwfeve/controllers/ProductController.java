package com.example.productservicedecmwfeve.controllers;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.productservicedecmwfeve.dtos.ExceptionDto;
import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.example.productservicedecmwfeve.models.Product;
import com.example.productservicedecmwfeve.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    // private RestTemplate restTemplate;


    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
        // this.restTemplate = restTemplate;
    }

    
    @GetMapping()   //localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
        // return productService.getAllProducts();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException{
        
        // throw new RuntimeException("Something went WWrong");
        // try{
            return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK);
        // }catch(ArithmeticException exception){
        //     ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //     return response;
        // }

    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setTitle("A new product");    
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id){
        return new Product();
    }

    @PutMapping("path/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {      
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        
    }

    // @ExceptionHandler(ProductNotExistsException.class)
    // public ResponseEntity<Void> handleProductNotExistsException(){
    //     return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    // }
    
    // @ExceptionHandler(ProductNotExistsException.class)
    // public ResponseEntity<ExceptionDto> handleProductNotExistsException(
    //         ProductNotExistsException exception
    //     ){
    //         ExceptionDto dto = new ExceptionDto();
    //         dto.setMessage(exception.getMessage());
    //         return new ResponseEntity<>(dto,HttpStatus.FORBIDDEN);
    //     }
}
