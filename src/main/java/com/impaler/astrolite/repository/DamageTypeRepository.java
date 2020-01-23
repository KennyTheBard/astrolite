package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.combat.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageTypeRepository extends JpaRepository<DamageType, Long> {

}
