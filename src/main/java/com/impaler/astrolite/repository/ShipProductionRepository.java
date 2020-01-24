package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ShipProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipProductionRepository extends JpaRepository<ShipProduction, Long> {

}
