package com.impaler.astrolite.model.colony;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "building_to_colony")
public class BuildingToColony {

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
