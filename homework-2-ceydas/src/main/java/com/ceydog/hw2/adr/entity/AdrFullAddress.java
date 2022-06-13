package com.ceydog.hw2.adr.entity;

import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_FULL_ADDRESS")
@Getter
@Setter
public class AdrFullAddress extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AdrNeighborhood", sequenceName = "ADR_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "AdrNeighborhood", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADDRESS_DESCRIPTION", length = 100, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADR_STREET")
    private AdrStreet adrStreet; //The smallest unit of address

}
