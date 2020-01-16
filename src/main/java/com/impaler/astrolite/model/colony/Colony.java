package com.impaler.astrolite.model.colony;

import com.impaler.astrolite.model.Player;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "max_resource_storage")
    private Integer maxResourceStorage;

    @Column(name = "ore")
    private Integer ore;

    @Column(name = "ore_per_hour")
    private Integer orePerHour;

    @Column(name = "carbonite")
    private Integer carbonite;

    @Column(name = "carbonite_per_hour")
    private Integer carbonitePerHour;

    @Column(name = "uranium")
    private Integer uranium;

    @Column(name = "uranium_per_hour")
    private Integer uraniumPerHour;

    @Column(name = "last_resource_interrogation")
    private LocalDateTime lastResourceInterrogation;

}
