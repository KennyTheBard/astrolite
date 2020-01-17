package com.impaler.astrolite.model.research;

import com.impaler.astrolite.model.colony.Building;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "research_at")
    private Building researchAt;

    @Column(name = "research_time_sec")
    private Integer researchTimeInSec;

    @OneToMany(mappedBy = "research")
    private List<ConstraintResearch> constraints;

    @OneToMany(mappedBy = "research")
    private List<Bonus> bonuses;
}
