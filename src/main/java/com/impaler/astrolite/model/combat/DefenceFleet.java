package com.impaler.astrolite.model.combat;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.base.SolarSystem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "defence_fleet")
public class DefenceFleet implements IFleet {

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
    private List<DefenceFleetShip> ships;

    @Override
    public boolean defeated() {
        if (Objects.isNull(ships)) return true;

        for (DefenceFleetShip ship : ships) {
            if (ship.getQuantity() > 0) {
                return false;
            }
        }

        return true;
    }
}