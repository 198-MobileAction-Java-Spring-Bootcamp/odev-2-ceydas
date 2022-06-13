package com.ceydog.hw2.adr.dao;

import com.ceydog.hw2.adr.entity.AdrNeighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdrNeighborhoodDao extends JpaRepository<AdrNeighborhood, Long> {
}
