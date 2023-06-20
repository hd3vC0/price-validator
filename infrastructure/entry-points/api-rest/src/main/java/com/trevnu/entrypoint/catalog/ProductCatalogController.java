package com.trevnu.entrypoint.catalog;

import com.trevnu.entrypoint.catalog.dto.RequestProductDTO;
import com.trevnu.entrypoint.catalog.dto.ResponseProductDTO;
import com.trevnu.entrypoint.catalog.mapper.ResponseMapper;
import com.trevnu.model.price.ProductPrice;
import com.trevnu.usecase.ProductPriceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ProductCatalogController {

    private final ProductPriceUseCase productPriceUseCase;

    @PostMapping(path = "/product-price")
    public ResponseProductDTO getProductPrice(@RequestBody @Valid RequestProductDTO dto){
        ProductPrice productPrice = productPriceUseCase.getPrice(dto.getProductId(), dto.getDate(), dto.getBrandId());
        return ResponseMapper.INSTANCE.toDTO(productPrice, dto);
    }
}
