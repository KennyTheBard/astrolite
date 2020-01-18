package com.impaler.astrolite.model.resource;

import com.impaler.astrolite.model.colony.Building;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "building_resource_cost")
public class BuildingResourceCost implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @Column(name = "cost")
    private Integer cost;

}
