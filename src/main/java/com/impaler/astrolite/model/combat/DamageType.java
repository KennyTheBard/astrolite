package com.impaler.astrolite.model.combat;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "damage_type")
public class DamageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
