package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.base.ColonyResourceInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyResourceInventoryRepository extends JpaRepository<ColonyResourceInventory, Long> {

}
