package com.impaler.astrolite.service;

import com.impaler.astrolite.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShipService {

    @Autowired
    private ShipRepository shipRepository;

    public Map<String, Object> getDefence() {
        Map<String, Object> stats = new HashMap<>();
        shipRepository.findAll().forEach(ship -> {
            stats.put(ship.getName(), ship.getDefensiveStats().stream()
                    .collect(
                            Collectors.toMap(
                                    def -> def.getAgainst().getName(),
                                    def -> def.getDefence()
                            )
                    )
            );
        });
        return stats;
    }

    private Float calculateDamageReduction(Integer armor) {
        return 1f - 100f / (100f + armor);
    }

}
