package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.space.AttackFleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackFleetRepository extends JpaRepository<AttackFleet, Long> {

}
