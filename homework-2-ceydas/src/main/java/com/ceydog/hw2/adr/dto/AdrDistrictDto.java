package com.ceydog.hw2.adr.dto;


import lombok.Data;

@Data
public class AdrDistrictDto {
    private Long id;
    private String name;
    private Long adrCityId;
}
