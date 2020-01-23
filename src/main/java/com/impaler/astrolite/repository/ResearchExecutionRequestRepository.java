package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ResearchExecutionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchExecutionRequestRepository extends JpaRepository<ResearchExecutionRequest, Long> {

}
