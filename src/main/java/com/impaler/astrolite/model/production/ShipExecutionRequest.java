package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.ColonyBuilding;
import com.impaler.astrolite.model.combat.Ship;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ship_execution_request")
public class ShipExecutionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_creation_time")
    private LocalDateTime requestCreationTime;

    @ManyToOne
    @JoinColumn(name = "colony_building_id")
    private ColonyBuilding requestLocation;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Column(name = "quantity")
    private Integer quantity;

}
