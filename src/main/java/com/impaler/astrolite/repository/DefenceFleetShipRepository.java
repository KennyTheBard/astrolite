package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.combat.DefenceFleetShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenceFleetShipRepository extends JpaRepository<DefenceFleetShip, Long> {

}
