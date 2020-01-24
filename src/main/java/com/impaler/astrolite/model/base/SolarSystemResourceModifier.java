package com.impaler.astrolite.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "solar_system_resource_modifier")
public class SolarSystemResourceModifier implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "solar_system_id")
    private SolarSystem solarSystem;

    @Column(name = "value")
    private Float value;

}
