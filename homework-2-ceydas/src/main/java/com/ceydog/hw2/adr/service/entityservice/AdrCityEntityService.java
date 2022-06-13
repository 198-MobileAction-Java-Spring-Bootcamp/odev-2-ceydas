package com.ceydog.hw2.adr.service.entityservice;

import com.ceydog.hw2.adr.dao.AdrCityDao;
import com.ceydog.hw2.adr.entity.AdrCity;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrCityEntityService extends BaseEntityService<AdrCity, AdrCityDao> {
    public AdrCityEntityService(AdrCityDao dao) {
        super(dao);
    }

    public AdrCity findByPlateCode(Integer plateCode) {

        List<AdrCity> adrCityList = super.findAll();

        if (adrCityList.isEmpty()){
            throw new RuntimeException("No cities found!");
        }

        for (AdrCity adrCity : adrCityList) {
            if (adrCity.getPlateCode() == plateCode){
                return adrCity;
            }
        }

        throw new RuntimeException("No such city with given plate code exists!");

    }
}
