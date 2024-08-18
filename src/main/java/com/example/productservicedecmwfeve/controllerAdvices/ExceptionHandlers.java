package com.example.productservicedecmwfeve.controllerAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.productservicedecmwfeve.dtos.ArithmeticExceptionDto;
import com.example.productservicedecmwfeve.dtos.ExceptionDto;
import com.example.productservicedecmwfeve.exceptions.ProductNotExistsException;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleArithmeticException(){
        ArithmeticExceptionDto ArithmeticExceptionDto = new ArithmeticExceptionDto();
        ArithmeticExceptionDto.setMessage("Something Has gone Wrong");
        return new ResponseEntity<>(ArithmeticExceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> ArrayIndexOutOfBoundsException(){
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(
            ProductNotExistsException exception
        ){
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage(exception.getMessage());
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
};

