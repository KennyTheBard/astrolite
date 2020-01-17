package com.impaler.astrolite.model;

import com.impaler.astrolite.model.colony.Colony;
import com.impaler.astrolite.model.research.PlayerToResearch;
import com.impaler.astrolite.model.space.AttackFleet;
import com.impaler.astrolite.model.space.DefenceFleet;
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
