package com.impaler.astrolite.model.space;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ship_to_defence_fleet")
public class ShipToDefenceFleet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship shipId;

    @Id
    @ManyToOne
    @JoinColumn(name = "fleet_id")
    private AttackFleet fleet;

    @Column(name = "quantity")
    private Integer quantity;

}