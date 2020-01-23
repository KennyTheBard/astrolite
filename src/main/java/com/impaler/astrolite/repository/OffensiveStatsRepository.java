package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.combat.OffensiveStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffensiveStatsRepository extends JpaRepository<OffensiveStats, Long> {

}
