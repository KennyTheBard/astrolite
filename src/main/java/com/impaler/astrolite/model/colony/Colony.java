package com.impaler.astrolite.model.colony;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "colony")
public class Colony {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "soalr_system")
    private SolarSystem solarSystem;

    @Column(name = "ore")
    private Long ore;

    @Column(name = "ore_storage")
    private Long oreStorage;

    @Column(name = "carbon")
    private Long carbon;

    @Column(name = "carbon_storage")
    private Long carbonStorage;

    @Column(name = "crystalite")
    private Long crystalite;

    @Column(name = "crystalite_storage")
    private Long crystaliteStorage;

}
