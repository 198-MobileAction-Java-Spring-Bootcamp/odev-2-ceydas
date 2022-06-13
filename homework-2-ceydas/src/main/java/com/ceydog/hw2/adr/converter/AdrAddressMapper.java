package com.ceydog.hw2.adr.converter;


import com.ceydog.hw2.adr.dao.AdrCityDao;
import com.ceydog.hw2.adr.dto.*;
import com.ceydog.hw2.adr.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrAddressMapper {

    AdrAddressMapper INSTANCE = Mappers.getMapper(AdrAddressMapper.class);

    /** Street Mappings **/
    @Mapping(source = "adrNeighborhood.id", target = "adrNeighborhoodId")
    AdrStreetDto convertToAdrStreetDto(AdrStreet adrStreet);

    @Mapping(source = "adrNeighborhoodId", target = "adrNeighborhood.id")
    AdrStreet convertToAdrStreet(AdrStreetDto adrStreetDto);

    List<AdrStreetDto> convertToAddStreetDtoList(List<AdrStreet> adrStreetList);


    /** Neighborhood Mappings **/
    @Mapping(source = "adrDistrict.id", target = "adrDistrictId")
    AdrNeighborhoodDto convertToAdrNeighborhoodDto(AdrNeighborhood adrNeighborhood);
    @Mapping(source = "adrDistrictId", target = "adrDistrict.id")
    AdrNeighborhood convertToAdrNeighborhood(AdrNeighborhoodDto adrNeighborhoodDto);

    List<AdrNeighborhoodDto> convertToAdrNeighborhoodDtoList(List<AdrNeighborhood> adrNeighborhoodList);

    /** District Mappings **/
    @Mapping(source = "adrCity.id", target = "adrCityId")
    AdrDistrictDto convertToAdrDistrictDto(AdrDistrict adrDistrict);

    @Mapping(source = "adrCityId", target = "adrCity.id")
    AdrDistrict convertToAdrDistrict(AdrDistrictDto adrDistrictDto);

    List<AdrDistrictDto> convertToAdrDistrictDtoList(List<AdrDistrict> adrDistrictList);

    /** City Mappings **/
    @Mapping(source = "adrCountry.id", target = "adrCountryId")
    AdrCityDto convertToAdrCityDto(AdrCity adrCity);

    @Mapping(source = "adrCountryId", target = "adrCountry.id")
    AdrCity convertToAdrCity(AdrCityDto adrCityDto);

    List<AdrCityDto> convertToAdrCityDtoList(List<AdrCity> adrCityList);

    /** Country Mappings **/
    AdrCountry convertToAdrCountry(AdrCountryDto adrCountryDto);
    AdrCountryDto convertToAdrCountryDto(AdrCountry adrCountry);
    List<AdrCountryDto> convertToAdrCountryDtoList(List<AdrCountry> adrCountryList);








}
