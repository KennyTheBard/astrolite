package com.impaler.astrolite.model.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "solar_system_resource_modifier")
public class SolarSystemResourceModifier implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "solar_system_id")
    private SolarSystem solarSystem;

    @Column(name = "modifier")
    private Float modifier;

}
