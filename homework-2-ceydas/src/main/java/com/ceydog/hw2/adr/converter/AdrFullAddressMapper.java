package com.ceydog.hw2.adr.converter;


import com.ceydog.hw2.adr.dto.AdrFullAddressGetRequestDto;
import com.ceydog.hw2.adr.dto.AdrFullAddressSaveRequestDto;
import com.ceydog.hw2.adr.dto.AdrStreetDto;
import com.ceydog.hw2.adr.entity.AdrFullAddress;
import com.ceydog.hw2.adr.entity.AdrStreet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrFullAddressMapper {
    AdrFullAddressMapper INSTANCE = Mappers.getMapper(AdrFullAddressMapper.class);

    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "description", target = "addressDescription")
    @Mapping(source = "adrStreet.name", target = "streetName")
    @Mapping(source = "adrStreet.doorNo", target = "doorNo")
    @Mapping(source = "adrStreet.apartmentNo", target = "apartmentNo")
    @Mapping(source = "adrStreet.adrNeighborhood.name", target = "neighborhoodName")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.name", target = "districtName")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.adrCity.name", target = "cityName")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.adrCity.adrCountry.name", target = "countryName")
    AdrFullAddressGetRequestDto convertToAdrFullAddressGetRequestDto(AdrFullAddress adrFullAddress);

    @Mapping(source = "id", target = "addressId")
    @Mapping(source = "description", target = "addressDescription")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.adrCity.adrCountry.id", target = "countryId")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.adrCity.id", target = "cityId")
    @Mapping(source = "adrStreet.adrNeighborhood.adrDistrict.id", target = "districtId")
    @Mapping(source = "adrStreet.adrNeighborhood.id", target = "neighborhoodId")
    @Mapping(source = "adrStreet.id", target = "streetId")
    @Mapping(source = "adrStreet.name", target = "streetName")
    @Mapping(source = "adrStreet.doorNo", target = "doorNo")
    @Mapping(source = "adrStreet.apartmentNo", target = "apartmentNo")
    AdrFullAddressSaveRequestDto convertToAdrFullAddressSaveRequestDto(AdrFullAddress adrFullAddress);


    @Mapping(source = "addressId", target = "id")
    @Mapping(source = "addressDescription", target = "description")
    @Mapping(source = "streetId", target = "adrStreet.id")
    AdrFullAddress convertToAdrFullAddressAdrFullAddress(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto);


    List<AdrFullAddressSaveRequestDto> convertToAdrFullAddressSaveRequestDtoList(List<AdrFullAddress> adrFullAddressList);

    List<AdrFullAddressGetRequestDto> convertToAdrFullAddressGetRequestDtoList(List<AdrFullAddress> adrFullAddressList);

}
