package com.impaler.astrolite.model.base;

import com.impaler.astrolite.model.production.Research;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "research_resource_cost")
public class ResearchResourceCost implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @Id
    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

    @Column(name = "cost")
    private Integer cost;

}