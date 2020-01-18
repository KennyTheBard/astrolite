package com.impaler.astrolite.model.colony;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.resource.ColonyResourceInventory;
import com.impaler.astrolite.model.resource.ColonyResourceProduction;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
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
    private List<BuildingToColony> buildings;

    @OneToMany(mappedBy = "colony")
    private List<ColonyResourceInventory> resourceInventories;

    @OneToMany(mappedBy = "colony")
    private List<ColonyResourceProduction> resourceProductions;
}
