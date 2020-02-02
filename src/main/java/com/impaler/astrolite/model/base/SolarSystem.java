package com.impaler.astrolite.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "solarSystem", cascade = CascadeType.ALL)
    private List<SolarSystemResourceModifier> modifiers;

}
