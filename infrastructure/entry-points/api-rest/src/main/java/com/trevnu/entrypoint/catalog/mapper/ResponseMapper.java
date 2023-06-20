package com.trevnu.entrypoint.catalog.mapper;

import com.trevnu.entrypoint.catalog.dto.RequestProductDTO;
import com.trevnu.entrypoint.catalog.dto.ResponseProductDTO;
import com.trevnu.model.price.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseMapper {
    public final ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);
    @Mapping(target = "productId", source = "productPrice.productId")
    @Mapping(target = "brandId", source = "productPrice.brandId")
    ResponseProductDTO toDTO(ProductPrice productPrice, RequestProductDTO dto);
}
