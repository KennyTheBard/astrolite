package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.space.DefenceFleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefenceFleetRepository extends JpaRepository<DefenceFleet, Long> {

}