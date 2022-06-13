package com.ceydog.hw2.adr.service.entityservice;


import com.ceydog.hw2.adr.dao.AdrStreetDao;
import com.ceydog.hw2.adr.entity.AdrStreet;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrStreetEntityService extends BaseEntityService<AdrStreet, AdrStreetDao> {

    public AdrStreetEntityService(AdrStreetDao dao) {
        super(dao);
    }
}
