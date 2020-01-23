package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.ResearchPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchPlayerRepository extends JpaRepository<ResearchPlayer, Long> {

}

