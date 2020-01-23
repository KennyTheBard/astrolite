package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.ShipResourceCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipResourceCostRepository extends JpaRepository<ShipResourceCost, Long> {

}
