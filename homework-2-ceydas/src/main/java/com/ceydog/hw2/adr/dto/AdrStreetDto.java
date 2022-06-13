package com.ceydog.hw2.adr.dto;

import lombok.Data;

@Data
public class AdrStreetDto {
    private Long id;
    private Long adrNeighborhoodId;
    private String name;
    private String doorNo;
    private Long apartmentNo;
}
