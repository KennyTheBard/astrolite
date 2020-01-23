package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.model.base.Resource;
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
