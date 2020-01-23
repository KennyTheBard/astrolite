package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.SolarSystemResourceModifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarSystemResourceModifierRepository extends JpaRepository<SolarSystemResourceModifier, Long> {

}