package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrCity;
import com.ceydog.hw2.adr.entity.AdrFullAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrFullAddressDao extends JpaRepository<AdrFullAddress, Long> {

}
