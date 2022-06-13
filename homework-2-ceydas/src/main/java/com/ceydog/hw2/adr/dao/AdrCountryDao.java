package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrCountryDao extends JpaRepository<AdrCountry, Long> {
}
