package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrStreet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrStreetDao extends JpaRepository<AdrStreet, Long> {
}
