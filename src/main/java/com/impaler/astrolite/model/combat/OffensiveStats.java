package com.impaler.astrolite.model.combat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @ManyToOne
    @JoinColumn(name = "damage_type_id")
    private DamageType damageType;

    @Column(name = "attack_speed")
    private Integer attackSpeed;

}
