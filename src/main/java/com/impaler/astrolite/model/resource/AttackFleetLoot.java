package com.impaler.astrolite.model.resource;

import com.impaler.astrolite.model.space.AttackFleet;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "attack_fleet_loot")
public class AttackFleetLoot implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "attack_fleet_id")
    private AttackFleet attackFleet;

    @Column(name = "quantity")
    private Integer quantity;

}
