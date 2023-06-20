package com.trevnu.jparepository.service;

import com.trevnu.jparepository.mapper.PriceMapper;
import com.trevnu.jparepository.repository.PriceRepository;
import com.trevnu.model.price.ProductPrice;
import com.trevnu.model.price.gateways.PriceServiceGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
@AllArgsConstructor
public class PriceService implements PriceServiceGateway {
    private final PriceRepository priceRepository;

    @Override
    public List<ProductPrice> getPrice(Integer productId, Date date, Long brandId) {
        List<com.trevnu.jparepository.entity.Price> result = priceRepository.getProductPriceByIdDateBrand(productId, new Timestamp(date.getTime()), brandId);
        return PriceMapper.INSTANCE.toModelList(result);
    }
}
