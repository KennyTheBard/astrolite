package com.impaler.astrolite.model.combat;

import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.model.production.ConstraintShip;
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

    @Column(name = "inventory")
    private Integer inventory;

    @OneToMany(mappedBy = "owner")
    private List<OffensiveStats> offensiveStats;

    @OneToMany(mappedBy = "owner")
    private List<DefensiveStats> defensiveStats;

    @OneToMany(mappedBy = "ship")
    private List<ConstraintShip> constraints;
}
