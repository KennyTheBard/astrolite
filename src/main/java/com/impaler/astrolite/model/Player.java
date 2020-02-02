package com.impaler.astrolite.model;

import com.impaler.astrolite.model.base.Colony;
import com.impaler.astrolite.model.production.ResearchPlayer;
import com.impaler.astrolite.model.combat.AttackFleet;
import com.impaler.astrolite.model.combat.DefenceFleet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<AttackFleet> attackFleets;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<DefenceFleet> defenceFleets;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<ResearchPlayer> researched;

}
