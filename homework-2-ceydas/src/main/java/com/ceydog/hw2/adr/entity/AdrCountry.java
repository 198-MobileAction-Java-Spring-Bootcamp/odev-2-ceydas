package com.ceydog.hw2.adr.entity;

import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_COUNTRY")
@Getter
@Setter
public class AdrCountry extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AdrCountry", sequenceName = "ADR_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "AdrCountry", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "COUNTRY_CODE", unique = true, nullable = false)
    private Integer countryCode;

}
