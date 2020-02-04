package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.model.base.Colony;
import com.impaler.astrolite.model.base.ColonyBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColonyBuildingRepository extends JpaRepository<ColonyBuilding, Long> {

    Optional<ColonyBuilding> findOneByColonyAndBuilding(Colony colony, Building building);

}
