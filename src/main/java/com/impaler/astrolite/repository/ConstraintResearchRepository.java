package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ConstraintResearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstraintResearchRepository extends JpaRepository<ConstraintResearch, Long> {

}
