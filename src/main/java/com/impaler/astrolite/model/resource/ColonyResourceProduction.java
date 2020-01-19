package com.impaler.astrolite.model.resource;

import com.impaler.astrolite.model.colony.Colony;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "colony_resource_production")
public class ColonyResourceProduction implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @Column(name = "production_per_second")
    private Float productionPerSecond;

}
