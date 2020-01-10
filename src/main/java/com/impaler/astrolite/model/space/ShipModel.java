package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.enums.DamageType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ship_model")
public class ShipModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private Integer health;

    @Column(name = "damage")
    private Integer damage;

    @Column(name = "damage_type")
    private DamageType damageType;

    @Column(name = "attack_speed")
    private Integer attackSpeed;

    @Column(name = "travel_speed")
    private Integer travelSpeed;

}