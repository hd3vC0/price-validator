package com.trevnu.jparepository.service;

import com.trevnu.jparepository.entity.Brand;
import com.trevnu.jparepository.entity.Price;
import com.trevnu.jparepository.repository.PriceRepository;
import com.trevnu.model.price.ProductPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    @Test
    void getPrice(){
        when(priceRepository.getProductPriceByIdDateBrand(any(), any(), any())).thenReturn(
                Arrays.asList(
                        new Price(
                                1L,
                                new Brand(1L, "ZARA"),
                                Timestamp.valueOf("2020-06-14 15:00:00"),
                                Timestamp.valueOf("2020-06-14 18:30:00"),
                                2,
                                35455,
                                1,
                                25.45f,
                                "EUR"
                        )
                )
        );

        List<ProductPrice> price = priceService.getPrice(35455, new Date(), 1L);

        ProductPrice productPrice = price.get(0);
        assertEquals(1, productPrice.getBrandId());
        assertEquals(25.45f, productPrice.getPrice());


    }
}
