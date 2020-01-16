package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.colony.SolarSystem;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "defence_fleet")
public class DefenceFleet {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;

    @OneToOne
    @JoinColumn(name = "stationed_at")
    private SolarSystem stationedAt;

}