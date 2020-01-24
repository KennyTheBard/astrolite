package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.model.production.Research;
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