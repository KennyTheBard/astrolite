package com.impaler.astrolite.model.execution;

import com.impaler.astrolite.model.colony.BuildingToColony;
import com.impaler.astrolite.model.space.Ship;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ship_execution_request")
public class ShipExecutionRequest {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "request_creation_time")
    private LocalDateTime requestCreationTime;

    @ManyToOne
    @JoinColumn(name = "building_to_colony_id")
    private BuildingToColony requestLocation;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Column(name = "quantity")
    private Integer quantity;

}
