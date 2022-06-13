package com.ceydog.hw2.adr.dto;

import com.ceydog.hw2.adr.entity.AdrNeighborhood;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class AdrFullAddressSaveRequestDto {
    private Long addressId;
    private String addressDescription;
    private Long countryId;
    private Long cityId;
    private Long districtId;
    private Long neighborhoodId;

    //If these don't exist, then a new entry will be created

    private Long streetId;
    private String streetName;
    private String doorNo;
    private Long apartmentNo;



}
