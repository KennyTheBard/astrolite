package com.impaler.astrolite.model.colony;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "solar_system")
public class SolarSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance_to_core")
    private Integer distanceToCore;

    @Column(name = "angle_to_core")
    private Integer angleToCore;

    @Column(name = "ore_modifier")
    private Float oreModifier;

    @Column(name = "carbonite_modifier")
    private Float carboniteModifier;

    @Column(name = "uranium_modifier")
    private Float uraniumModifier;

}
