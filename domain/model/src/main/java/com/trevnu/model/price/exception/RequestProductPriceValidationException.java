package com.trevnu.model.price.exception;

public class RequestProductPriceValidationException extends RuntimeException{
    public RequestProductPriceValidationException(){
        super("Bad request");
    }

    public RequestProductPriceValidationException(String message){
        super(message);
    }
}
