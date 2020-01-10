package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.enums.ShipClass;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "space_ship")
public class Ship {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ship_class")
    private ShipClass shipClass;

    @Column(name = "name")
    private String name;

    @Column(name = "ship_model")
    private ShipModel shipModel;

}
