package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.colony.SolarSystem;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attack_fleet")
public class AttackFleet {

    @Id
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

}
