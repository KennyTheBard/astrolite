package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.combat.AttackFleetShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackFleetShipRepository extends JpaRepository<AttackFleetShip, Long> {

}
