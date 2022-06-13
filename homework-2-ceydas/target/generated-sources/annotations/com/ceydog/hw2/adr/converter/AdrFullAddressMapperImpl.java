package com.ceydog.hw2.adr.converter;

import com.ceydog.hw2.adr.dto.AdrFullAddressGetRequestDto;
import com.ceydog.hw2.adr.dto.AdrFullAddressSaveRequestDto;
import com.ceydog.hw2.adr.entity.AdrCity;
import com.ceydog.hw2.adr.entity.AdrCountry;
import com.ceydog.hw2.adr.entity.AdrDistrict;
import com.ceydog.hw2.adr.entity.AdrFullAddress;
import com.ceydog.hw2.adr.entity.AdrNeighborhood;
import com.ceydog.hw2.adr.entity.AdrStreet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T19:35:44+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
public class AdrFullAddressMapperImpl implements AdrFullAddressMapper {

    @Override
    public AdrFullAddressGetRequestDto convertToAdrFullAddressGetRequestDto(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }

        AdrFullAddressGetRequestDto adrFullAddressGetRequestDto = new AdrFullAddressGetRequestDto();

        adrFullAddressGetRequestDto.setAddressId( adrFullAddress.getId() );
        adrFullAddressGetRequestDto.setAddressDescription( adrFullAddress.getDescription() );
        adrFullAddressGetRequestDto.setStreetName( adrFullAddressAdrStreetName( adrFullAddress ) );
        adrFullAddressGetRequestDto.setDoorNo( adrFullAddressAdrStreetDoorNo( adrFullAddress ) );
        adrFullAddressGetRequestDto.setApartmentNo( adrFullAddressAdrStreetApartmentNo( adrFullAddress ) );
        adrFullAddressGetRequestDto.setNeighborhoodName( adrFullAddressAdrStreetAdrNeighborhoodName( adrFullAddress ) );
        adrFullAddressGetRequestDto.setDistrictName( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictName( adrFullAddress ) );
        adrFullAddressGetRequestDto.setCityName( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityName( adrFullAddress ) );
        adrFullAddressGetRequestDto.setCountryName( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityAdrCountryName( adrFullAddress ) );

        return adrFullAddressGetRequestDto;
    }

    @Override
    public AdrFullAddressSaveRequestDto convertToAdrFullAddressSaveRequestDto(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }

        AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto = new AdrFullAddressSaveRequestDto();

        adrFullAddressSaveRequestDto.setAddressId( adrFullAddress.getId() );
        adrFullAddressSaveRequestDto.setAddressDescription( adrFullAddress.getDescription() );
        adrFullAddressSaveRequestDto.setCountryId( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityAdrCountryId( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setCityId( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityId( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setDistrictId( adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictId( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setNeighborhoodId( adrFullAddressAdrStreetAdrNeighborhoodId( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setStreetId( adrFullAddressAdrStreetId( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setStreetName( adrFullAddressAdrStreetName( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setDoorNo( adrFullAddressAdrStreetDoorNo( adrFullAddress ) );
        adrFullAddressSaveRequestDto.setApartmentNo( adrFullAddressAdrStreetApartmentNo( adrFullAddress ) );

        return adrFullAddressSaveRequestDto;
    }

    @Override
    public AdrFullAddress convertToAdrFullAddressAdrFullAddress(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto) {
        if ( adrFullAddressSaveRequestDto == null ) {
            return null;
        }

        AdrFullAddress adrFullAddress = new AdrFullAddress();

        adrFullAddress.setAdrStreet( adrFullAddressSaveRequestDtoToAdrStreet( adrFullAddressSaveRequestDto ) );
        adrFullAddress.setId( adrFullAddressSaveRequestDto.getAddressId() );
        adrFullAddress.setDescription( adrFullAddressSaveRequestDto.getAddressDescription() );

        return adrFullAddress;
    }

    @Override
    public List<AdrFullAddressSaveRequestDto> convertToAdrFullAddressSaveRequestDtoList(List<AdrFullAddress> adrFullAddressList) {
        if ( adrFullAddressList == null ) {
            return null;
        }

        List<AdrFullAddressSaveRequestDto> list = new ArrayList<AdrFullAddressSaveRequestDto>( adrFullAddressList.size() );
        for ( AdrFullAddress adrFullAddress : adrFullAddressList ) {
            list.add( convertToAdrFullAddressSaveRequestDto( adrFullAddress ) );
        }

        return list;
    }

    @Override
    public List<AdrFullAddressGetRequestDto> convertToAdrFullAddressGetRequestDtoList(List<AdrFullAddress> adrFullAddressList) {
        if ( adrFullAddressList == null ) {
            return null;
        }

        List<AdrFullAddressGetRequestDto> list = new ArrayList<AdrFullAddressGetRequestDto>( adrFullAddressList.size() );
        for ( AdrFullAddress adrFullAddress : adrFullAddressList ) {
            list.add( convertToAdrFullAddressGetRequestDto( adrFullAddress ) );
        }

        return list;
    }

    private String adrFullAddressAdrStreetName(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        String name = adrStreet.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String adrFullAddressAdrStreetDoorNo(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        String doorNo = adrStreet.getDoorNo();
        if ( doorNo == null ) {
            return null;
        }
        return doorNo;
    }

    private Long adrFullAddressAdrStreetApartmentNo(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        Long apartmentNo = adrStreet.getApartmentNo();
        if ( apartmentNo == null ) {
            return null;
        }
        return apartmentNo;
    }

    private String adrFullAddressAdrStreetAdrNeighborhoodName(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        String name = adrNeighborhood.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictName(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
        if ( adrDistrict == null ) {
            return null;
        }
        String name = adrDistrict.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityName(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
        if ( adrDistrict == null ) {
            return null;
        }
        AdrCity adrCity = adrDistrict.getAdrCity();
        if ( adrCity == null ) {
            return null;
        }
        String name = adrCity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityAdrCountryName(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
        if ( adrDistrict == null ) {
            return null;
        }
        AdrCity adrCity = adrDistrict.getAdrCity();
        if ( adrCity == null ) {
            return null;
        }
        AdrCountry adrCountry = adrCity.getAdrCountry();
        if ( adrCountry == null ) {
            return null;
        }
        String name = adrCountry.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityAdrCountryId(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
        if ( adrDistrict == null ) {
            return null;
        }
        AdrCity adrCity = adrDistrict.getAdrCity();
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

    private Long adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictAdrCityId(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
        if ( adrNeighborhood == null ) {
            return null;
        }
        AdrDistrict adrDistrict = adrNeighborhood.getAdrDistrict();
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

    private Long adrFullAddressAdrStreetAdrNeighborhoodAdrDistrictId(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        AdrNeighborhood adrNeighborhood = adrStreet.getAdrNeighborhood();
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

    private Long adrFullAddressAdrStreetAdrNeighborhoodId(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
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

    private Long adrFullAddressAdrStreetId(AdrFullAddress adrFullAddress) {
        if ( adrFullAddress == null ) {
            return null;
        }
        AdrStreet adrStreet = adrFullAddress.getAdrStreet();
        if ( adrStreet == null ) {
            return null;
        }
        Long id = adrStreet.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected AdrStreet adrFullAddressSaveRequestDtoToAdrStreet(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto) {
        if ( adrFullAddressSaveRequestDto == null ) {
            return null;
        }

        AdrStreet adrStreet = new AdrStreet();

        adrStreet.setId( adrFullAddressSaveRequestDto.getStreetId() );

        return adrStreet;
    }
}
