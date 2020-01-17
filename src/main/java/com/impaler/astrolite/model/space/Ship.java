package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.colony.Building;
import com.impaler.astrolite.model.research.ConstraintShip;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Integer travelSpeed;

    @Column(name = "health")
    private Integer health;

    @Column(name = "storage")
    private Integer storage;

    @OneToMany(mappedBy = "owner")
    private List<OffensiveStats> offensiveStats;

    @OneToMany(mappedBy = "ship")
    private List<ConstraintShip> constraints;
}
