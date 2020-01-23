package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ShipExecutionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipExecutionRequestRepository extends JpaRepository<ShipExecutionRequest, Long> {

}
