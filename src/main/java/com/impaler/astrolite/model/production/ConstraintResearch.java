package com.impaler.astrolite.model.production;

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