package com.trevnu.model.price.exception;

public class ProductPriceNotFoundException extends RuntimeException{
    public ProductPriceNotFoundException(){
        super("Product price not found");
    }

    public ProductPriceNotFoundException(String message){
        super(message);
    }
}
