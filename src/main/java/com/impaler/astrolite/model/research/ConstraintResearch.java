package com.impaler.astrolite.model.research;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "constraint_research")
public class ConstraintResearch {

    @Id
    @OneToOne
    @JoinColumn(name = "research_id")
    private Research research;

    @Id
    @ManyToOne
    @JoinColumn(name = "required_research_id")
    private Research requiredResearch;
}