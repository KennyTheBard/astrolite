package com.impaler.astrolite.model.combat;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defensive_stats")
public class DefensiveStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Ship owner;

    @Column(name = "armor")
    private Integer armor;

    @ManyToOne
    @JoinColumn(name = "damage_type_id")
    private DamageType against;

}