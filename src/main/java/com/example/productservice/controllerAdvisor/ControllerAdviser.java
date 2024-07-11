package com.example.productservice.controllerAdvisor;

import com.example.productservice.controller.CategoryController;
import com.example.productservice.controller.ProductController;
import com.example.productservice.dtos.ExceptionResponseDto;
import com.example.productservice.exception.CategoryNotFoundException;
import com.example.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {ProductController.class, CategoryController.class})
public class ControllerAdviser {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleCategoryNotFoundException(CategoryNotFoundException ex) {
            ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                    ex.getMessage(),
                    404
            );
            return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleProductNotFoundException(ProductNotFoundException ex) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                ex.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }
}
