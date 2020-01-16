package com.impaler.astrolite.model.colony;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "solar_system")
public class SolarSystem {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance_to_core")
    private Integer distanceToCore;

    @Column(name = "distance_to_core")
    private Integer angleToCore;

    @Column(name = "ore_modif")
    private Float oreModifier;

    @Column(name = "carbon_modif")
    private Float carbonModifier;

    @Column(name = "crystalite_modif")
    private Float crystaliteModifier;

}
