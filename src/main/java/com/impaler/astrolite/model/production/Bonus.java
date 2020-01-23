package com.impaler.astrolite.model.production;

import com.impaler.astrolite.model.enums.BonusType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bonus")
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "research_id")
    private Research research;

    @Column(name = "bonus_type")
    private BonusType type;

    @Column(name = "bonus_value")
    private Integer value;
}
