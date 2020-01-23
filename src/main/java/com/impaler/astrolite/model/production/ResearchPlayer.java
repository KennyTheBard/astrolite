package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.Player;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "research_player")
public class ResearchPlayer implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
