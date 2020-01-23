package com.impaler.astrolite.model.base;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
