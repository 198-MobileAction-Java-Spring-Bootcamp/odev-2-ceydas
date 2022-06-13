package com.ceydog.hw2.adr.service.entityservice;


import com.ceydog.hw2.adr.dao.AdrNeighborhoodDao;
import com.ceydog.hw2.adr.entity.AdrNeighborhood;
import com.ceydog.hw2.gen.service.entity_service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdrNeighborhoodEntityService extends BaseEntityService<AdrNeighborhood, AdrNeighborhoodDao> {


    public AdrNeighborhoodEntityService(AdrNeighborhoodDao dao) {
        super(dao);
    }
}
