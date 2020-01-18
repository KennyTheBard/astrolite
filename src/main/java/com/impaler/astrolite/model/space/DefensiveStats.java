package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.enums.DamageType;
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

    @Column(name = "defence")
    private Integer defence;

    @Column(name = "damage_type")
    private DamageType against;

}
