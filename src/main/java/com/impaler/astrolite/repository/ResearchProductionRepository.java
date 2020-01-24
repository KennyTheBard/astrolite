package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ResearchProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchProductionRepository extends JpaRepository<ResearchProduction, Long> {

}
