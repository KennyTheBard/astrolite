package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.ColonyBuilding;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "research_execution_request")
public class ResearchExecutionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_creation_time")
    private LocalDateTime requestCreationTime;

    @ManyToOne
    @JoinColumn(name = "colony_building_id")
    private ColonyBuilding requestLocation;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

}
