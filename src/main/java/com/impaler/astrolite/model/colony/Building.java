package com.impaler.astrolite.model.colony;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "max_level")
    private Integer maxLevel;



}
