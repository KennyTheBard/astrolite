package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.ColonyBuilding;
import com.impaler.astrolite.model.combat.Ship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ship_production")
public class ShipProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "colony_building_id")
    private ColonyBuilding requestLocation;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Column(name = "quantity")
    private Integer quantity;

}
