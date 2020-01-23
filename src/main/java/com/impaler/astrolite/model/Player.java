package com.impaler.astrolite.model;

import com.impaler.astrolite.model.base.Colony;
import com.impaler.astrolite.model.production.PlayerToResearch;
import com.impaler.astrolite.model.combat.AttackFleet;
import com.impaler.astrolite.model.combat.DefenceFleet;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Colony> colonies;

    @OneToMany(mappedBy = "owner")
    private List<AttackFleet> attackFleets;

    @OneToMany(mappedBy = "owner")
    private List<DefenceFleet> defenceFleets;

    @OneToMany(mappedBy = "player")
    private List<PlayerToResearch> researched;

}
