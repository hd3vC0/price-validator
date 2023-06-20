package com.trevnu.jparepository.repository;

import com.trevnu.jparepository.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p WHERE :date BETWEEN p.startDate AND p.endDate AND p.productId=:productId AND " +
            "p.brand.id=:brandId ORDER BY p.priority DESC")
    List<Price> getProductPriceByIdDateBrand(@Param("productId") Integer productId,
                                             @Param("date") Date date,
                                             @Param("brandId") Long brandId);
}
