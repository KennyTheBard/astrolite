package com.impaler.astrolite.model.research;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.space.AttackFleet;
import com.impaler.astrolite.model.space.Ship;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "player_to_research")
public class PlayerToResearch {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
