package com.ceydog.hw2.adr.entity;


import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_DISTRICT")
@Getter
@Setter
public class AdrDistrict extends BaseEntity {

    @Id
    @SequenceGenerator(name = "AdrDistrict", sequenceName = "ADR_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "AdrDistrict", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADR_CITY")
    private AdrCity adrCity;


}
