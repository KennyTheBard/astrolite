package com.impaler.astrolite.model.space;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ship_to_attack_fleet")
public class ShipToAttackFleet {

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