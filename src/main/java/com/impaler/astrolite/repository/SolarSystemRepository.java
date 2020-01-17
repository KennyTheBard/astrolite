package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.colony.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {
}
