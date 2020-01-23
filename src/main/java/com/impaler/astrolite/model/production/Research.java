package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.Building;
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
}