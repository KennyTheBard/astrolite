package com.impaler.astrolite.model.research;

import com.impaler.astrolite.model.space.Ship;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "constraint_ship")
public class ConstraintShip {

    @Id
    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @Id
    @ManyToOne
    @JoinColumn(name = "required_research_id")
    private Research requiredResearch;
}