package com.ceydog.hw2.adr.dto;


import com.ceydog.hw2.adr.entity.AdrDistrict;
import lombok.Data;

@Data
public class AdrNeighborhoodDto {
    private Long id;
    private Long adrDistrictId;
    private String name;
}
