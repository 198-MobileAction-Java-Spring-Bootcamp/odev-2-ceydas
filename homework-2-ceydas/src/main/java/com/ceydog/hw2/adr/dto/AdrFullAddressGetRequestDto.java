package com.ceydog.hw2.adr.dto;

import lombok.Data;

@Data
public class AdrFullAddressGetRequestDto {
    //Address descriptors
    private Long addressId;
    private String addressDescription;

    //Country fields
    private String countryName;

    //City Fields
    private String cityName;

    //District Fields
    private String districtName;

    //Neighborhood Fields
    private String neighborhoodName;

    //Street Fields
    private String streetName;
    private String doorNo;
    private Long apartmentNo;


}
