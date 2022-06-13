package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrDistrictDao extends JpaRepository<AdrDistrict, Long> {
}
