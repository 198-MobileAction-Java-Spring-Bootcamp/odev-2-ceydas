package com.ceydog.hw2.adr.entity;

import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_CITY")
@Getter
@Setter
public class AdrCity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AdrCity", sequenceName = "ADR_CITY_ID_SEQ")
    @GeneratedValue(generator = "AdrCity", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PLATE_CODE", unique = true, nullable = false)
    private Integer plateCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADR_CITY")
    private AdrCountry adrCountry;

}
