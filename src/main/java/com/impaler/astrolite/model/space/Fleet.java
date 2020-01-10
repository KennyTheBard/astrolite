package com.impaler.astrolite.model.space;

import com.impaler.astrolite.model.Player;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fleet")
public class Fleet {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "owner")
    private Player owner;

}