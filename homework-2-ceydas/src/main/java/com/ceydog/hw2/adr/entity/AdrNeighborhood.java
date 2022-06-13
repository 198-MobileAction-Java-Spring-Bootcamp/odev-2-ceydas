package com.ceydog.hw2.adr.entity;

import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_NEIGHBORHOOD")
@Getter
@Setter
public class AdrNeighborhood extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AdrNeighborhood", sequenceName = "ADR_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "AdrNeighborhood", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADR_DISTRICT")
    private AdrDistrict adrDistrict;

}
