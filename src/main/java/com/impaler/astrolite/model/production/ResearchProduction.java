package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.ColonyBuilding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "research_production")
public class ResearchProduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "colony_building_id")
    private ColonyBuilding requestLocation;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
