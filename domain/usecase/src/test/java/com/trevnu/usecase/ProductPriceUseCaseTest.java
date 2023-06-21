package com.trevnu.usecase;

import com.trevnu.model.price.ProductPrice;
import com.trevnu.model.price.exception.ProductPriceNotFoundException;
import com.trevnu.model.price.gateways.PriceServiceGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductPriceUseCaseTest {

    @Mock
    private PriceServiceGateway priceServiceGateway;

    @InjectMocks
    private ProductPriceUseCase productPriceUseCase;

    @Test
    void getPrice_whenRepositoryReturn_twoItems(){
        when(priceServiceGateway.getPrice(any(), any(), any())).thenReturn(
                Arrays.asList(
                        new ProductPrice(
                                1,
                                Timestamp.valueOf("2020-06-14 15:00:00"),
                                Timestamp.valueOf("2020-06-14 18:30:00"),
                                2,
                                35455,
                                1,
                                25.45f,
                                "EUR"
                        ),
                        new ProductPrice(
                                1,
                                Timestamp.valueOf("2020-06-14 00:00:00"),
                                Timestamp.valueOf("2020-12-31 23:59:59"),
                                1,
                                35455,
                                0,
                                35.50f,
                                "EUR"
                        )
                )
        );

        ProductPrice price = productPriceUseCase.getPrice(35455, new Date(), 1L);
        assertEquals(25.45f, price.getPrice());
    }

    @Test
    void getPrice_whenRepositoryReturn_emptyList(){
        when(priceServiceGateway.getPrice(any(), any(), any())).thenReturn(Collections.emptyList());

        assertThrows(ProductPriceNotFoundException.class,
                () -> productPriceUseCase.getPrice(35455, new Date(), 1L)
        );
    }
}
