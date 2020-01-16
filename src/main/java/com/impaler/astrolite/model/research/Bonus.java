package com.impaler.astrolite.model.research;

import com.impaler.astrolite.model.enums.BonusType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bonus")
public class Bonus {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

    @Column(name = "bonus_type")
    private BonusType bonusType;

    @Column(name = "value")
    private Integer value;
}
