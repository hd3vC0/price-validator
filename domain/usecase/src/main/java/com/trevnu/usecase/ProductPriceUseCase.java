package com.trevnu.usecase;

import com.trevnu.model.price.ProductPrice;
import com.trevnu.model.price.exception.ProductPriceNotFoundException;
import com.trevnu.model.price.gateways.PriceServiceGateway;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ProductPriceUseCase {

    private final PriceServiceGateway priceServiceGateway;
    public ProductPrice getPrice(Integer productId, Date date, Long brandId){
        return priceServiceGateway.getPrice(productId, date, brandId).stream()
                .findFirst()
                .orElseThrow(ProductPriceNotFoundException::new);
    }
}
