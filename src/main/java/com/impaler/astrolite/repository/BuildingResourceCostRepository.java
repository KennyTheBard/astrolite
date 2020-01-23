package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.BuildingResourceCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingResourceCostRepository extends JpaRepository<BuildingResourceCost, Long> {

}