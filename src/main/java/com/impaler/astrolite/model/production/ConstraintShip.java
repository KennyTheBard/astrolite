package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.combat.Ship;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "constraint_ship")
public class ConstraintShip implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Id
    @ManyToOne
    @JoinColumn(name = "required_research_id")
    private Research requiredResearch;
}