package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ConstraintShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintShipRepository extends JpaRepository<ConstraintShip, Long> {

}