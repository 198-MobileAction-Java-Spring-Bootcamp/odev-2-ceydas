package com.ceydog.hw2.adr.dto;

import com.ceydog.hw2.adr.entity.AdrFullAddress;
import lombok.Data;


@Data
public class AdrCountryDto {
    private Long id;
    private String name;
    private Integer countryCode;
}
