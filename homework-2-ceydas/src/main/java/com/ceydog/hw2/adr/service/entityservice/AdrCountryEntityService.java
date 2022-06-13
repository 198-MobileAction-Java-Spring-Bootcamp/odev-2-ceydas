package com.ceydog.hw2.adr.service.entityservice;

import com.ceydog.hw2.adr.dao.AdrCountryDao;
import com.ceydog.hw2.adr.entity.AdrCity;
import com.ceydog.hw2.adr.entity.AdrCountry;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrCountryEntityService extends BaseEntityService<AdrCountry, AdrCountryDao> {
    public AdrCountryEntityService(AdrCountryDao dao) {
        super(dao);
    }

    public AdrCountry findByCountryCode(Integer countryCode) {

        List<AdrCountry> adrCountryList = super.findAll();

        if (adrCountryList.isEmpty()){
            throw new RuntimeException("No countries found!");
        }

        for (AdrCountry adrCountry : adrCountryList) {
            if (adrCountry.getCountryCode() == countryCode){
                return adrCountry;
            }
        }

        throw new RuntimeException("No such country with given country code exists!");
    }
}
