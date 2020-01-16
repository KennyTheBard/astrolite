package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.colony.Building;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "space_ship")
public class Ship {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "build_at")
    private Building buildAt;

    @Column(name = "build_time_sec")
    private Integer buildTimeInSec;

    @Column(name = "travel_speed")
    private Float travelSpeed;

    @Column(name = "health")
    private Integer health;

    @Column(name = "storage")
    private Integer storage;
}
