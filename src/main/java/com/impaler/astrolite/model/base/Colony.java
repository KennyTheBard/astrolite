package com.impaler.astrolite.model.base;

import com.impaler.astrolite.model.Player;
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
@Table(name = "colony")
public class Colony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;

    @OneToOne
    @JoinColumn(name = "solar_system_id")
    private SolarSystem solarSystem;

    @Column(name = "max_resource_inventory")
    private Integer maxResourceInventory;

    @OneToMany(mappedBy = "colony")
    private List<ColonyBuilding> buildings;

    @OneToMany(mappedBy = "colony")
    private List<ColonyResourceInventory> resourceInventories;

    @OneToMany(mappedBy = "colony")
    private List<ColonyResourceProduction> resourceProductions;
}
