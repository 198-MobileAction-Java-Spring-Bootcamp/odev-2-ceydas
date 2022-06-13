package com.ceydog.hw2.adr.converter;

import com.ceydog.hw2.adr.dto.AdrCityDto;
import com.ceydog.hw2.adr.dto.AdrCountryDto;
import com.ceydog.hw2.adr.dto.AdrDistrictDto;
import com.ceydog.hw2.adr.dto.AdrNeighborhoodDto;
import com.ceydog.hw2.adr.dto.AdrStreetDto;
import com.ceydog.hw2.adr.entity.AdrCity;
import com.ceydog.hw2.adr.entity.AdrCountry;
import com.ceydog.hw2.adr.entity.AdrDistrict;
import com.ceydog.hw2.adr.entity.AdrNeighborhood;
import com.ceydog.hw2.adr.entity.AdrStreet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T17:00:44+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class AdrAddressMapperImpl implements AdrAddressMapper {

    @Override
    public AdrStreetDto convertToAdrStreetDto(AdrStreet adrStreet) {
        if ( adrStreet == null ) {
            return null;
        }

        AdrStreetDto adrStreetDto = new AdrStreetDto();

        adrStreetDto.setAdrNeighborhoodId( adrStreetAdrNeighborhoodId( adrStreet ) );
        adrStreetDto.setId( adrStreet.getId() );
        adrStreetDto.setName( adrStreet.getName() );
        adrStreetDto.setDoorNo( adrStreet.getDoorNo() );
        adrStreetDto.setApartmentNo( adrStreet.getApartmentNo() );

        return adrStreetDto;
    }

    @Override
    public AdrStreet convertToAdrStreet(AdrStreetDto adrStreetDto) {
        if ( adrStreetDto == null ) {
            return null;
        }

        AdrStreet adrStreet = new AdrStreet();

        adrStreet.setAdrNeighborhood( adrStreetDtoToAdrNeighborhood( adrStreetDto ) );
        adrStreet.setId( adrStreetDto.getId() );
        adrStreet.setName( adrStreetDto.getName() );
        adrStreet.setDoorNo( adrStreetDto.getDoorNo() );
        adrStreet.setApartmentNo( adrStreetDto.getApartmentNo() );

        return adrStreet;
    }

    @Override
    public List<AdrStreetDto> convertToAddStreetDtoList(List<AdrStreet> adrStreetList) {
        if ( adrStreetList == null ) {
            return null;
        }

        List<AdrStreetDto> list = new ArrayList<AdrStreetDto>( adrStreetList.size() );
        for ( AdrStreet adrStreet : adrStreetList ) {
            list.add( convertToAdrStreetDto( adrStreet ) );
        }

        return list;
    }

    @Override
    public AdrNeighborhoodDto convertToAdrNeighborhoodDto(AdrNeighborhood adrNeighborhood) {
        if ( adrNeighborhood == null ) {
            return null;
        }

        AdrNeighborhoodDto adrNeighborhoodDto = new AdrNeighborhoodDto();

        adrNeighborhoodDto.setAdrDistrictId( adrNeighborhoodAdrDistrictId( adrNeighborhood ) );
        adrNeighborhoodDto.setId( adrNeighborhood.getId() );
        adrNeighborhoodDto.setName( adrNeighborhood.getName() );

        return adrNeighborhoodDto;
    }

    @Override
    public AdrNeighborhood convertToAdrNeighborhood(AdrNeighborhoodDto adrNeighborhoodDto) {
        if ( adrNeighborhoodDto == null ) {
            return null;
        }

        AdrNeighborhood adrNeighborhood = new AdrNeighborhood();

        adrNeighborhood.setAdrDistrict( adrNeighborhoodDtoToAdrDistrict( adrNeighborhoodDto ) );
        adrNeighborhood.setId( adrNeighborhoodDto.getId() );
        adrNeighborhood.setName( adrNeighborhoodDto.getName() );

        return adrNeighborhood;
    }

    @Override
    public List<AdrNeighborhoodDto> convertToAdrNeighborhoodDtoList(List<AdrNeighborhood> adrNeighborhoodList) {
        if ( adrNeighborhoodList == null ) {
            return null;
        }

        List<AdrNeighborhoodDto> list = new ArrayList<AdrNeighborhoodDto>( adrNeighborhoodList.size() );
        for ( AdrNeighborhood adrNeighborhood : adrNeighborhoodList ) {
            list.add( convertToAdrNeighborhoodDto( adrNeighborhood ) );
        }

        return list;
    }

    @Override
    public AdrDistrictDto convertToAdrDistrictDto(AdrDistrict adrDistrict) {
        if ( adrDistrict == null ) {
            return null;
        }

        AdrDistrictDto adrDistrictDto = new AdrDistrictDto();

        adrDistrictDto.setAdrCityId( adrDistrictAdrCityId( adrDistrict ) );
        adrDistrictDto.setId( adrDistrict.getId() );
        adrDistrictDto.setName( adrDistrict.getName() );

        return adrDistrictDto;
    }

    @Override
    public AdrDistrict convertToAdrDistrict(AdrDistrictDto adrDistrictDto) {
        if ( adrDistrictDto == null ) {
            return null;
        }

        AdrDistrict adrDistrict = new AdrDistrict();

        adrDistrict.setAdrCity( adrDistrictDtoToAdrCity( adrDistrictDto ) );
        adrDistrict.setId( adrDistrictDto.getId() );
        adrDistrict.setName( adrDistrictDto.getName() );

        return adrDistrict;
    }

    @Override
    public List<AdrDistrictDto> convertToAdrDistrictDtoList(List<AdrDistrict> adrDistrictList) {
        if ( adrDistrictList == null ) {
            return null;
        }

        List<AdrDistrictDto> list = new ArrayList<AdrDistrictDto>( adrDistrictList.size() );
        for ( AdrDistrict adrDistrict : adrDistrictList ) {
            list.add( convertToAdrDistrictDto( adrDistrict ) );
        }

        return list;
    }

    @Override
    public AdrCityDto convertToAdrCityDto(AdrCity adrCity) {
        if ( adrCity == null ) {
            return null;
        }

        AdrCityDto adrCityDto = new AdrCityDto();

        adrCityDto.setAdrCountryId( adrCityAdrCountryId( adrCity ) );
        adrCityDto.setId( adrCity.getId() );
        adrCityDto.setName( adrCity.getName() );
        adrCityDto.setPlateCode( adrCity.getPlateCode() );

        return adrCityDto;
    }

    @Override
    public AdrCity convertToAdrCity(AdrCityDto adrCityDto) {
        if ( adrCityDto == null ) {
            return null;
        }

        AdrCity adrCity = new AdrCity();

        adrCity.setAdrCountry( adrCityDtoToAdrCountry( adrCityDto ) );
        adrCity.setId( adrCityDto.getId() );
        adrCity.setName( adrCityDto.getName() );
        adrCity.setPlateCode( adrCityDto.getPlateCode() );

        return adrCity;
    }

    @Override
    public List<AdrCityDto> convertToAdrCityDtoList(List<AdrCity> adrCityList) {
        if ( adrCityList == null ) {
            return null;
        }

        List<AdrCityDto> list = new ArrayList<AdrCityDto>( adrCityList.size() );
        for ( AdrCity adrCity : adrCityList ) {
            list.add( convertToAdrCityDto( adrCity ) );
        }

        return list;
    }

    @Override
    public AdrCountry convertToAdrCountry(AdrCountryDto adrCountryDto) {
        if ( adrCountryDto == null ) {
            return null;
        }

        AdrCountry adrCountry = new AdrCountry();

        adrCountry.setId( adrCountryDto.getId() );
        adrCountry.setName( adrCountryDto.getName() );
        adrCountry.setCountryCode( adrCountryDto.getCountryCode() );

        return adrCountry;
    }

    @Override
    public AdrCountryDto convertToAdrCountryDto(AdrCountry adrCountry) {
        if ( adrCountry == null ) {
            return null;
        }

        AdrCountryDto adrCountryDto = new AdrCountryDto();

        adrCountryDto.setId( adrCountry.getId() );
        adrCountryDto.setName( adrCountry.getName() );
        adrCountryDto.setCountryCode( adrCountry.getCountryCode() );

        return adrCountryDto;
    }

    @Override
    public List<AdrCountryDto> convertToAdrCountryDtoList(List<AdrCountry> adrCountryList) {
        if ( adrCountryList == null ) {
            return null;
        }

        List<AdrCountryDto> list = new ArrayList<AdrCountryDto>( adrCountryList.size() );
        for ( AdrCountry adrCountry : adrCountryList ) {
            list.add( convertToAdrCountryDto( adrCountry ) );
        }

        return list;
    }

    private Long adrStreetAdrNeighborhoodId(AdrStreet adrStreet) {
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        Long id = adrNeighborhood.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AdrNeighborhood adrStreetDtoToAdrNeighborhood(AdrStreetDto adrStreetDto) {
        if ( adrStreetDto == null ) {
            return null;
        }

        AdrNeighborhood adrNeighborhood = new AdrNeighborhood();

        adrNeighborhood.setId( adrStreetDto.getAdrNeighborhoodId() );

        return adrNeighborhood;
    }

    private Long adrNeighborhoodAdrDistrictId(AdrNeighborhood adrNeighborhood) {
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
        if ( adrDistrict == null ) {
            return null;
        }
        Long id = adrDistrict.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AdrDistrict adrNeighborhoodDtoToAdrDistrict(AdrNeighborhoodDto adrNeighborhoodDto) {
        if ( adrNeighborhoodDto == null ) {
            return null;
        }

        AdrDistrict adrDistrict = new AdrDistrict();

        adrDistrict.setId( adrNeighborhoodDto.getAdrDistrictId() );

        return adrDistrict;
    }

    private Long adrDistrictAdrCityId(AdrDistrict adrDistrict) {
        if ( adrDistrict == null ) {
            return null;
        }
        AdrCity adrCity = adrDistrict.getAdrCity();
        if ( adrCity == null ) {
            return null;
        }
        Long id = adrCity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AdrCity adrDistrictDtoToAdrCity(AdrDistrictDto adrDistrictDto) {
        if ( adrDistrictDto == null ) {
            return null;
        }

        AdrCity adrCity = new AdrCity();

        adrCity.setId( adrDistrictDto.getAdrCityId() );

        return adrCity;
    }

    private Long adrCityAdrCountryId(AdrCity adrCity) {
        if ( adrCity == null ) {
            return null;
        }
        AdrCountry adrCountry = adrCity.getAdrCountry();
        if ( adrCountry == null ) {
            return null;
        }
        Long id = adrCountry.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AdrCountry adrCityDtoToAdrCountry(AdrCityDto adrCityDto) {
        if ( adrCityDto == null ) {
            return null;
        }

        AdrCountry adrCountry = new AdrCountry();

        adrCountry.setId( adrCityDto.getAdrCountryId() );

        return adrCountry;
    }
}
