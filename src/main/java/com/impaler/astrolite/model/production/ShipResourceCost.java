package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.model.combat.Ship;
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
@Table(name = "ship_resource_cost")
public class ShipResourceCost implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Column(name = "cost")
    private Integer cost;

}