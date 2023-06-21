package com.trevnu.model.price;

import lombok.*;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
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
