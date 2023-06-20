package com.trevnu.model.price;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@ToString
public class ProductPrice {
    private Integer brandId;
    private Date startDate;
    private Date endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Float price;
    private String currency;
}
