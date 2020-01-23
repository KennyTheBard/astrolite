package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.combat.DefensiveStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefensiveStatsRepository extends JpaRepository<DefensiveStats, Long> {

}