package com.trevnu.jparepository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BRANDS")
@Builder(toBuilder = true)
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "BRAND_NAME")
    private String brandName;

}
