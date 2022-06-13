package com.ceydog.hw2.adr.service.entityservice;

import com.ceydog.hw2.adr.dao.AdrFullAddressDao;
import com.ceydog.hw2.adr.entity.AdrFullAddress;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrFullAddressEntityService extends BaseEntityService<AdrFullAddress, AdrFullAddressDao> {

    public AdrFullAddressEntityService(AdrFullAddressDao dao) {
        super(dao);
    }
}
