package com.ceydog.hw2.adr.service;


import com.ceydog.hw2.adr.converter.AdrAddressMapper;
import com.ceydog.hw2.adr.converter.AdrFullAddressMapper;
import com.ceydog.hw2.adr.dto.*;
import com.ceydog.hw2.adr.entity.*;
import com.ceydog.hw2.adr.service.entityservice.*;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrStreetService {

    private final AdrStreetEntityService adrStreetEntityService;
    private final AdrNeighborhoodEntityService adrNeighborhoodEntityService;
    private final AdrDistrictEntityService adrDistrictEntityService;
    private final AdrCityEntityService adrCityEntityService;
    private final AdrCountryEntityService adrCountryEntityService;
    private final AdrFullAddressEntityService adrFullAddressEntityService;


    /** Street Services **/

    public AdrStreet saveStreet(AdrStreetDto adrStreetDto){

        Long adrNeighborhoodId = adrStreetDto.getAdrNeighborhoodId();
        if (!adrNeighborhoodEntityService.existsById(adrNeighborhoodId)){
            throw new RuntimeException("Neighborhood with id " + adrNeighborhoodId + " does not exist!");
        }

        //The neighborhood id exists.
        //Dto must be converted to Entity
        AdrStreet adrStreet = AdrAddressMapper.INSTANCE.convertToAdrStreet(adrStreetDto);

        //Save to DAO via Entity Service
        adrStreetEntityService.save(adrStreet);

        return adrStreet;
    }

    public AdrStreetDto findStreetById(Long id){

        AdrStreet adrStreet = adrStreetEntityService.findByIdWithControl(id);

        AdrStreetDto adrStreetDto = AdrAddressMapper.INSTANCE.convertToAdrStreetDto(adrStreet);

        return adrStreetDto;
    }

    public List<AdrStreetDto> findAllStreets(){

        //Find all Street entities
        List<AdrStreet> adrStreetList = adrStreetEntityService.findAll();

        //Convert the list of entities to DTO Format.
        List<AdrStreetDto> adrStreetDtoList = AdrAddressMapper.INSTANCE.convertToAddStreetDtoList(adrStreetList);

        return adrStreetDtoList;
    }

    /** Neighborhood Services **/

    public AdrNeighborhood saveNeighborhood(AdrNeighborhoodDto adrNeighborhoodDto){

        //Check if district id exists
        Long districtId = adrNeighborhoodDto.getAdrDistrictId();
        if (!adrDistrictEntityService.existsById(districtId)){
            throw new RuntimeException("District with id " + districtId + " does not exist!");
        }

        //Convert DTO to entity
        AdrNeighborhood adrNeighborhood = AdrAddressMapper.INSTANCE.convertToAdrNeighborhood(adrNeighborhoodDto);

        adrNeighborhoodEntityService.save(adrNeighborhood);

        return adrNeighborhood;

    }

    public List<AdrStreetDto> findAllStreetsOfNeighborHoodById(Long id){
        //Check if neighborhood exists
        if (!adrNeighborhoodEntityService.existsById(id)){
            throw new RuntimeException("Neighborhood does not exist!");
        }

        List<AdrStreet> streetList = adrStreetEntityService.findAll();

        if (!streetList.isEmpty()){
            streetList.removeIf(adrStreet -> adrStreet.getAdrNeighborhood().getId() != id);
        }

        //If no streets are found with given id return empty list
        if (streetList.isEmpty()){
            return Collections.emptyList();
        }

        List <AdrStreetDto> adrStreetDtoList = AdrAddressMapper.INSTANCE.convertToAddStreetDtoList(streetList);

        return adrStreetDtoList;

    }

    public List<AdrNeighborhoodDto> findAllNeighborhoods(){
        //Find all neighborhood entities
        List<AdrNeighborhood> adrNeighborhoodList = adrNeighborhoodEntityService.findAll();

        //Convert entity list to DTO List
        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrAddressMapper.INSTANCE.convertToAdrNeighborhoodDtoList(adrNeighborhoodList);

        return adrNeighborhoodDtoList;

    }

    public AdrNeighborhoodDto findNeighborhoodById(Long id){

        AdrNeighborhood adrNeighborhood = adrNeighborhoodEntityService.findByIdWithControl(id);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrAddressMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    /** District Services **/

    public List<AdrDistrictDto> findAllDistricts(){
        List<AdrDistrict> adrDistrictList = adrDistrictEntityService.findAll();


        List<AdrDistrictDto> adrDistrictDtoList = AdrAddressMapper.INSTANCE.convertToAdrDistrictDtoList(adrDistrictList);

        return adrDistrictDtoList;
    }

    public AdrDistrict saveDistrict(AdrDistrictDto adrDistrictDto){

        //Check if city id exists
        Long cityId = adrDistrictDto.getAdrCityId();
        if (!adrCityEntityService.existsById(cityId)){
            throw new RuntimeException("City with id " + cityId + " does not exist!");
        }

        //Convert DTO to entity
        AdrDistrict adrDistrict = AdrAddressMapper.INSTANCE.convertToAdrDistrict(adrDistrictDto);

        adrDistrictEntityService.save(adrDistrict);

        return adrDistrict;

    }

    public List<AdrNeighborhoodDto> findAllNeighborHoodsOfDistrictById(Long id){
        //Check if city exists
        if (!adrDistrictEntityService.existsById(id)){
            throw new RuntimeException("District does not exist!");
        }

        List<AdrNeighborhood> neighborhoodList = adrNeighborhoodEntityService.findAll();

        if (!neighborhoodList.isEmpty()){
            neighborhoodList.removeIf(neighborhood -> neighborhood.getAdrDistrict().getId() != id);
        }

        //If no neighborhoods are found with given id return empty list
        if (neighborhoodList.isEmpty()){
            return Collections.emptyList();
        }

        List <AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrAddressMapper.INSTANCE.convertToAdrNeighborhoodDtoList(neighborhoodList);

        return adrNeighborhoodDtoList;

    }

    /** City Services **/
    public List<AdrCityDto> findAllCities(){
        //Find all city entities
        List<AdrCity> adrCityList = adrCityEntityService.findAll();

        //Convert entity list to DTO List
        List<AdrCityDto> adrCityDtoList = AdrAddressMapper.INSTANCE.convertToAdrCityDtoList(adrCityList);

        return adrCityDtoList;

    }

    public AdrCityDto findCityByPlateCode(Integer plateCode){

        AdrCity adrCity = adrCityEntityService.findByPlateCode(plateCode);

        AdrCityDto adrCityDto = AdrAddressMapper.INSTANCE.convertToAdrCityDto(adrCity);

        return adrCityDto;
    }

    public AdrCity saveCity(AdrCityDto adrCityDto){
        //Check if country id exists

        Long countryId = adrCityDto.getAdrCountryId();
        if (!adrCountryEntityService.existsById(countryId)){
            throw new RuntimeException("Country with id " + countryId + " does not exist!");
        }

        //Convert DTO to entity
        AdrCity adrCity = AdrAddressMapper.INSTANCE.convertToAdrCity(adrCityDto);

        adrCityEntityService.save(adrCity);

        return adrCity;

    }

    public List<AdrDistrictDto> findDistrictsOfCityById(Long id){
        //Check if city exists
        if (!adrCityEntityService.existsById(id)){
            throw new RuntimeException("City does not exist!");
        }

        List<AdrDistrict> districtList = adrDistrictEntityService.findAll();

        if (!districtList.isEmpty()){
            districtList.removeIf(district -> district.getAdrCity().getId() != id);
        }

        //If no districts are found with given id return empty list
        if (districtList.isEmpty()){
            return Collections.emptyList();
        }

        List <AdrDistrictDto> districtDtoList = AdrAddressMapper.INSTANCE.convertToAdrDistrictDtoList(districtList);

        return districtDtoList;
    }


    /** Country Services **/

    public List<AdrCountryDto> findAllCountries(){
        List<AdrCountry> countryList = adrCountryEntityService.findAll();

        List<AdrCountryDto> countryDtoList = AdrAddressMapper.INSTANCE.convertToAdrCountryDtoList(countryList);

        return countryDtoList;

    }

    public AdrCountry saveCountry(AdrCountryDto adrCountryDto){

        //Convert DTO to entity
        AdrCountry adrCountry = AdrAddressMapper.INSTANCE.convertToAdrCountry(adrCountryDto);

        adrCountryEntityService.save(adrCountry);

        return adrCountry;
    }

    public AdrCountryDto findCountryByCountryCode(Integer countryCode){
        AdrCountry adrCountry = adrCountryEntityService.findByCountryCode(countryCode);

        AdrCountryDto adrCountryDto = AdrAddressMapper.INSTANCE.convertToAdrCountryDto(adrCountry);

        return adrCountryDto;
    }


    /** Full Address Services **/



    public List<AdrFullAddressGetRequestDto> findAllAddresses(){
        List<AdrFullAddress> adrFullAddressList = adrFullAddressEntityService.findAll();


        List<AdrFullAddressGetRequestDto> adrFullAddressGetRequestDtoList = AdrFullAddressMapper.INSTANCE.convertToAdrFullAddressGetRequestDtoList(adrFullAddressList);

        return adrFullAddressGetRequestDtoList;
    }

    public AdrFullAddress saveFullAddress(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto){

        Long countryId = adrFullAddressSaveRequestDto.getCountryId();
        Long cityId = adrFullAddressSaveRequestDto.getCityId();
        Long districtId = adrFullAddressSaveRequestDto.getDistrictId();
        Long neighborhoodId = adrFullAddressSaveRequestDto.getNeighborhoodId();

        if (!adrCountryEntityService.existsById(countryId) || !adrCityEntityService.existsById(cityId) || !adrDistrictEntityService.existsById(districtId) || !adrNeighborhoodEntityService.existsById(neighborhoodId)){
            throw new RuntimeException("You cannot add new address without specifying a valid country, city, district and neighborhood!");
        }

        //If street does not exist, create one!
        Long streetId = adrFullAddressSaveRequestDto.getStreetId();

        if (!adrStreetEntityService.existsById(streetId)){
            handleStreetDoesNotExist(adrFullAddressSaveRequestDto);
        }

        //Now that all fields are valid & updated, save new address.
        AdrFullAddress adrFullAddress = AdrFullAddressMapper.INSTANCE.convertToAdrFullAddressAdrFullAddress(adrFullAddressSaveRequestDto);
        adrFullAddressEntityService.save(adrFullAddress);


        return adrFullAddress;
    }

    public AdrFullAddressGetRequestDto deleteFullAddress(Long addressId){
        AdrFullAddress address = adrFullAddressEntityService.findByIdWithControl(addressId);

        //If address does exist, convert it to Dao,
        // then delete the street & address entry.
        AdrFullAddressGetRequestDto adrFullAddressGetRequestDto = AdrFullAddressMapper.INSTANCE.convertToAdrFullAddressGetRequestDto(address);

        adrStreetEntityService.delete(address.getAdrStreet());
        adrFullAddressEntityService.delete(address);

        return adrFullAddressGetRequestDto;
    }

    public AdrFullAddressGetRequestDto findAddressById(Long id){
        AdrFullAddress  adrFullAddress = adrFullAddressEntityService.findByIdWithControl(id);

        AdrFullAddressGetRequestDto adrFullAddressGetRequestDto = AdrFullAddressMapper.INSTANCE.convertToAdrFullAddressGetRequestDto(adrFullAddress);

        return adrFullAddressGetRequestDto;
    }

    private void handleStreetDoesNotExist(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto) {
        AdrStreetDto adrStreetDto = setStreetFromFullAddress(adrFullAddressSaveRequestDto);
        AdrStreet adrStreet = saveStreet(adrStreetDto);
        //Update street id
        adrFullAddressSaveRequestDto.setStreetId(adrStreet.getId());
    }

    private AdrStreetDto setStreetFromFullAddress(AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto) {
        AdrStreetDto adrStreetDto = new AdrStreetDto();

        adrStreetDto.setId(adrFullAddressSaveRequestDto.getStreetId());
        adrStreetDto.setName(adrFullAddressSaveRequestDto.getStreetName());
        adrStreetDto.setAdrNeighborhoodId(adrFullAddressSaveRequestDto.getNeighborhoodId());
        adrStreetDto.setApartmentNo(adrFullAddressSaveRequestDto.getApartmentNo());
        adrStreetDto.setDoorNo(adrFullAddressSaveRequestDto.getDoorNo());
        return adrStreetDto;
    }



}
