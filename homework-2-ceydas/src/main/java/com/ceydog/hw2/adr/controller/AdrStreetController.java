package com.ceydog.hw2.adr.controller;


import com.ceydog.hw2.adr.dto.*;
import com.ceydog.hw2.adr.entity.*;
import com.ceydog.hw2.adr.service.AdrStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdrStreetController {

    public final AdrStreetService adrStreetService; //General Service for all entities.

    /** Street Controller **/
    @PostMapping("/streets/save")
    public ResponseEntity<AdrStreet> saveStreet(@Valid @RequestBody AdrStreetDto adrStreetDto){

        AdrStreet adrStreet = adrStreetService.saveStreet(adrStreetDto);

        return ResponseEntity.ok(adrStreet);
    }

    @GetMapping("/streets")
    public ResponseEntity<List<AdrStreetDto>> findAllStreets(){

        List<AdrStreetDto> adrStreetDtoList = adrStreetService.findAllStreets();

        return ResponseEntity.ok(adrStreetDtoList);

    }

    @PatchMapping("/streets/update_name/")
    public ResponseEntity updateStreetName(@RequestParam Long id, String newName){

        //Find the street if it exists
        AdrStreetDto streetDto = adrStreetService.findStreetById(id);

        //Update name with new name
        streetDto.setName(newName);

        adrStreetService.saveStreet(streetDto);

        return ResponseEntity.ok(streetDto);

    }

    /** Neighborhood Controller **/
    @PostMapping("/neighborhoods/save")
    public ResponseEntity<AdrNeighborhood> saveStreet(@Valid @RequestBody AdrNeighborhoodDto adrNeighborhoodDto){

        AdrNeighborhood adrNeighborhood = adrStreetService.saveNeighborhood(adrNeighborhoodDto);

        return ResponseEntity.ok(adrNeighborhood);
    }

    @GetMapping("/neighborhoods")
    public ResponseEntity<List<AdrNeighborhoodDto>> findAllNeighborhoods(){

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = adrStreetService.findAllNeighborhoods();

        return ResponseEntity.ok(adrNeighborhoodDtoList);

    }

    @GetMapping("/neighborhoods/{id}/streets/")
    public ResponseEntity<List<AdrStreetDto>> findAllStreetsOfNeighborhoodById(Long id){

        List<AdrStreetDto> adrStreetDtoList = adrStreetService.findAllStreetsOfNeighborHoodById(id);

        return ResponseEntity.ok(adrStreetDtoList);

    }

    @PatchMapping("/neighborhoods/update_name/{id}")
    public ResponseEntity updateNeighborhoodName(@PathVariable Long id, @RequestParam String newName){

        //Find the neighborhood if it exists
        AdrNeighborhoodDto adrNeighborhoodDto = adrStreetService.findNeighborhoodById(id);

        //Update name with new name
        adrNeighborhoodDto.setName(newName);

        adrStreetService.saveNeighborhood(adrNeighborhoodDto);

        return ResponseEntity.ok(adrNeighborhoodDto);

    }

    /** District Controller **/
    @PostMapping("/districts/save")
    public ResponseEntity<AdrDistrict> saveDistrict(@Valid @RequestBody AdrDistrictDto adrDistrictDto){

        AdrDistrict adrDistrict = adrStreetService.saveDistrict(adrDistrictDto);

        return ResponseEntity.ok(adrDistrict);
    }

    @GetMapping("/districts")
    public ResponseEntity<List<AdrDistrictDto>> findAllDistricts(){

        List<AdrDistrictDto> adrDistrictDtoList = adrStreetService.findAllDistricts();

        return ResponseEntity.ok(adrDistrictDtoList);

    }
    @GetMapping("/districts/{id}/neighborhoods/")
    public ResponseEntity<List<AdrNeighborhoodDto>> findAllNeighborhoodsOfDistrictById(Long id){

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = adrStreetService.findAllNeighborHoodsOfDistrictById(id);

        return ResponseEntity.ok(adrNeighborhoodDtoList);
    }

    /** City Controller **/

    @GetMapping(path = "/cities/")
    public ResponseEntity<AdrCityDto> findCityByPlateCode(@Valid @RequestParam Integer plateCode){

        AdrCityDto adrCityDto = adrStreetService.findCityByPlateCode(plateCode);

        return ResponseEntity.ok(adrCityDto);
    }
    @PostMapping("/cities/save")
    public ResponseEntity<AdrCity> saveCity(@Valid @RequestBody AdrCityDto adrCityDto){

        AdrCity adrCity = adrStreetService.saveCity(adrCityDto);

        return ResponseEntity.ok(adrCity);
    }

    @GetMapping(path = "/cities")
    public ResponseEntity<List<AdrCityDto>> findAllCities(){

        List<AdrCityDto> adrCityDtoList = adrStreetService.findAllCities();

        return ResponseEntity.ok(adrCityDtoList);

    }
    @GetMapping("/cities/{id}/districts/")
    public ResponseEntity<List<AdrDistrictDto>> findAllDistrictsOfCityById(Long id){

        List<AdrDistrictDto> districtDtoList = adrStreetService.findDistrictsOfCityById(id);

        return ResponseEntity.ok(districtDtoList);
    }

    /** Country Controller **/
    @GetMapping("/countries")
    public ResponseEntity<List<AdrCountryDto>> findAllCountries(){

        List<AdrCountryDto> adrCountryDtoList = adrStreetService.findAllCountries();

        return ResponseEntity.ok(adrCountryDtoList);
    }

    @PostMapping("/countries/save/{id}")
    public ResponseEntity<AdrCountry> saveCountry(@Valid @RequestBody AdrCountryDto adrCountryDto){

        AdrCountry adrCountry = adrStreetService.saveCountry(adrCountryDto);

        return ResponseEntity.ok(adrCountry);
    }



    /** Full Address Controller **/
    @GetMapping("/addresses")
    public ResponseEntity<List<AdrFullAddressGetRequestDto>> findAllFullAddresses(){

        List<AdrFullAddressGetRequestDto> adrFullAddressGetRequestDtoList = adrStreetService.findAllAddresses();

        return ResponseEntity.ok(adrFullAddressGetRequestDtoList);
    }

    @PostMapping("/addresses/save")
    public ResponseEntity<AdrFullAddress> saveAddress(@Valid @RequestBody AdrFullAddressSaveRequestDto adrFullAddressSaveRequestDto){

        AdrFullAddress adrFullAddress = adrStreetService.saveFullAddress(adrFullAddressSaveRequestDto);

        return ResponseEntity.ok(adrFullAddress);
    }

    @PostMapping("/addresses/delete/{id}")
    public ResponseEntity<AdrFullAddressGetRequestDto> deleteAddress(Long id){

        AdrFullAddressGetRequestDto adrFullAddressGetRequestDto = adrStreetService.deleteFullAddress(id);

        return ResponseEntity.ok(adrFullAddressGetRequestDto);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<AdrFullAddressGetRequestDto> findAddressById(@PathVariable Long id){

        AdrFullAddressGetRequestDto adrFullAddressGetRequestDtoList = adrStreetService.findAddressById(id);

        return ResponseEntity.ok(adrFullAddressGetRequestDtoList);
    }








}
