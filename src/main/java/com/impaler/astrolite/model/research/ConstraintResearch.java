package com.impaler.astrolite.model.research;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "constraint_research")
public class ConstraintResearch implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

    @Id
    @ManyToOne
    @JoinColumn(name = "required_research_id")
    private Research requiredResearch;
}