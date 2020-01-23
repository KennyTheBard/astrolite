package com.impaler.astrolite.repository;

import com.impaler.astrolite.model.production.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {

}
