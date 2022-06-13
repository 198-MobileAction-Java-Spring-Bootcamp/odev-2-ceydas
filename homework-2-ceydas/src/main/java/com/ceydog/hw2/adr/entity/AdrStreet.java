package com.ceydog.hw2.adr.entity;

import com.ceydog.hw2.adr.dto.AdrStreetDto;
import com.ceydog.hw2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADR_STREET")
@Getter
@Setter
public class AdrStreet extends BaseEntity {

    @Id
    @SequenceGenerator(name = "AdrStreet", sequenceName = "ADR_STREET_ID_SEQ")
    @GeneratedValue(generator = "AdrStreet" ,strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "DOOR_NO", nullable = false)
    private String doorNo;

    @Column(name = "APARTMENT_NO", nullable = false)
    private Long apartmentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADR_NEIGHBORHOOD")
    private AdrNeighborhood adrNeighborhood;


}


