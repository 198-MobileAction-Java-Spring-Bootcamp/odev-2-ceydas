package com.ceydog.hw2.adr.dto;

import com.ceydog.hw2.adr.entity.AdrCountry;
import lombok.Data;


@Data
public class AdrCityDto {
    private Long id;
    private String name;
    private Integer plateCode;
    private Long adrCountryId;
}
