package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.Colony;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyRepository extends JpaRepository<Colony, Long> {

    Colony getColonyById(Long id);

    Colony save(Colony entity);
}

