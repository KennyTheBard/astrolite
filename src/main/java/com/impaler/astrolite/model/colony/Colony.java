package com.impaler.astrolite.model.colony;

import com.impaler.astrolite.model.Player;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "colony")
public class Colony {

    @Id
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

    @Column(name = "max_storage")
    private Integer maxStorage;

    @Column(name = "ore")
    private Integer ore;

    @Column(name = "ore_storage")
    private Integer orePerHour;

    @Column(name = "carbon")
    private Integer carbonite;

    @Column(name = "carbon_storage")
    private Integer carbonitePerHour;

    @Column(name = "crystalite")
    private Integer uranium;

    @Column(name = "crystalite_storage")
    private Integer uraniumPerHour;

}
