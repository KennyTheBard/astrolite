package com.impaler.astrolite.model.combat;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "defence_fleet_ship")
public class DefenceFleetShip implements Serializable, IFleetShip {

    @Id
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Id
    @ManyToOne
    @JoinColumn(name = "fleet_id")
    private DefenceFleet fleet;

    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public void destroyShips(int numberOfShipsToDestroy) {
        quantity = Math.max(0, quantity - numberOfShipsToDestroy);
    }
}