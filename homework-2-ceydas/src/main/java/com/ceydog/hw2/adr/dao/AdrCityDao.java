package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrCityDao extends JpaRepository<AdrCity, Long> {
}
