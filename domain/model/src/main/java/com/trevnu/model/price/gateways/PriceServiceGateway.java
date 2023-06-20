package com.trevnu.model.price.gateways;

import com.trevnu.model.price.ProductPrice;

import java.util.Date;
import java.util.List;

public interface PriceServiceGateway {
    public List<ProductPrice> getPrice(Integer productId, Date date, Long brandId);
}
