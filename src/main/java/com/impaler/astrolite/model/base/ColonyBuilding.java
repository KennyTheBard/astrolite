package com.impaler.astrolite.model.base;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "colony_building")
public class ColonyBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @Column(name = "current_level")
    private Integer currentLevel;
}
