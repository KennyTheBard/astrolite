package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.ColonyResourceProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyResourceProductionRepository extends JpaRepository<ColonyResourceProduction, Long> {

}