package com.impaler.astrolite.model.execution;

import com.impaler.astrolite.model.colony.BuildingToColony;
import com.impaler.astrolite.model.research.Research;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "research_execution_request")
public class ResearchExecutionRequest {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "request_creation_time")
    private LocalDateTime requestCreationTime;

    @ManyToOne
    @JoinColumn(name = "building_to_colony_id")
    private BuildingToColony requestLocation;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
