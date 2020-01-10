package com.impaler.astrolite.model.space;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fleet_ship")
public class FleetShip {

    @Id
    @Column(name = "fleet_id")
    private Long fleetId;

    @Id
    @Column(name = "ship_id")
    private Long shipId;

    @Column(name = "quantity")
    private Integer quantity;

}