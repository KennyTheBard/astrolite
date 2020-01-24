package com.impaler.astrolite.model.combat;

import com.impaler.astrolite.model.base.Resource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
