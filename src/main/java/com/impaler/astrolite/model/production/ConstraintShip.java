package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.combat.Ship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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