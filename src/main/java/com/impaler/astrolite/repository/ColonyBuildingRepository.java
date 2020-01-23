package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.ColonyBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyBuildingRepository extends JpaRepository<ColonyBuilding, Long> {

}