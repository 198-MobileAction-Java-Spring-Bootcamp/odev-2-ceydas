package com.ceydog.hw2.adr.service.entityservice;

import com.ceydog.hw2.adr.dao.AdrDistrictDao;
import com.ceydog.hw2.adr.entity.AdrDistrict;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrDistrictEntityService extends BaseEntityService<AdrDistrict, AdrDistrictDao> {
    public AdrDistrictEntityService(AdrDistrictDao dao) {
        super(dao);
    }
}
