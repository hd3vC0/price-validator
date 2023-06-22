package com.trevnu.entrypoint.catalog;

import com.trevnu.entrypoint.catalog.dto.GenericResponseDTO;
import com.trevnu.model.price.exception.ProductPriceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ProductCatalogControllerAdvise {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> validationException(MethodArgumentNotValidException exception){
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(
                        new GenericResponseDTO(
                                Instant.now(),
                                BAD_REQUEST.value(),
                                "Bad request"
                        )
                );
    }

    @ExceptionHandler(ProductPriceNotFoundException.class)
    public ResponseEntity<GenericResponseDTO> productPriceNotFoundHandler(ProductPriceNotFoundException exception){
        return ResponseEntity
                .status(NOT_FOUND)
                .body(
                        new GenericResponseDTO(
                                Instant.now(),
                                NOT_FOUND.value(),
                                "Price not found"
                        )
                );
    }

}
