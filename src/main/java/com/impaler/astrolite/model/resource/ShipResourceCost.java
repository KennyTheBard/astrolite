package com.impaler.astrolite.model.resource;

import com.impaler.astrolite.model.space.Ship;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
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