package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.enums.DamageType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "offensive_stats")
public class OffensiveStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Ship owner;

    @Column(name = "attack_damage")
    private Integer attackDamage;

    @Column(name = "damage_type")
    private DamageType damageType;

    @Column(name = "attack_speed")
    private Integer attackSpeed;

}
