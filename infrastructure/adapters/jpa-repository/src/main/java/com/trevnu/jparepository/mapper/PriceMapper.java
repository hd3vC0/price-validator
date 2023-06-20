package com.trevnu.jparepository.mapper;

import com.trevnu.model.price.ProductPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {

    public final PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(target = "brandId", source = "entity.brand.id")
    @Mapping(target = "price", source = "currentPrice")
    ProductPrice toModel(com.trevnu.jparepository.entity.Price entity);

    List<ProductPrice> toModelList(List<com.trevnu.jparepository.entity.Price> list);
}
