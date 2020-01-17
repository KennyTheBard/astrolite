package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.colony.SolarSystem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "defence_fleet")
public class DefenceFleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;

    @OneToOne
    @JoinColumn(name = "stationed_at")
    private SolarSystem stationedAt;

    @OneToMany(mappedBy = "fleet")
    private List<ShipToDefenceFleet> ships;

}