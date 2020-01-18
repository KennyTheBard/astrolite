package com.impaler.astrolite.model.resource;

import com.impaler.astrolite.model.colony.Colony;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "colony_resource_inventory")
public class ColonyResourceInventory implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "last_resource_interrogation")
    private LocalDateTime lastResourceInterrogation;

}
