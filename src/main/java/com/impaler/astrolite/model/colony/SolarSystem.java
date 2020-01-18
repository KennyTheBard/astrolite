package com.impaler.astrolite.model.colony;

import com.impaler.astrolite.model.resource.SolarSystemResourceModifier;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "solarSystem")
    private List<SolarSystemResourceModifier> modifiers;

}
