package com.impaler.astrolite.model.combat;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.base.SolarSystem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "attack_fleet")
public class AttackFleet implements IFleet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;

    @OneToOne
    @JoinColumn(name = "send_from")
    private SolarSystem sendFrom;

    @OneToOne
    @JoinColumn(name = "send_to")
    private SolarSystem sendTo;

    @Column(name = "travel_speed")
    private Integer travelSpeed;

    @OneToMany(mappedBy = "fleet", cascade = CascadeType.ALL)
    private List<AttackFleetShip> ships;

    @OneToMany(mappedBy = "attackFleet", cascade = CascadeType.ALL)
    private List<AttackFleetLoot> loot;

    @Override
    public boolean defeated() {
        if (Objects.isNull(ships)) return true;

        for (AttackFleetShip ship : ships) {
            if (ship.getQuantity() > 0) {
                return false;
            }
        }

        return true;
    }
}
