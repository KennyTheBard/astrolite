package com.impaler.astrolite.service;

import com.impaler.astrolite.model.base.Colony;
import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.repository.ColonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class ColonyService {

    @Autowired
    private ColonyRepository colonyRepository;

    public Map<String, Object> interrogateResource(Long id) {
        final Colony colony = colonyRepository.getColonyById(id);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        Map<Resource, Float> colonySupply = new HashMap<>();
        colony.getResourceProductions().forEach(p -> {
            colonySupply.put(p.getResource(), p.getProductionPerSecond());
        });

        colony.getResourceInventories().forEach(i -> {
            float secondsSinceLastUpdate = (float) Duration.between(i.getLastResourceInterrogation(), now).getSeconds();
            i.setQuantity(
                    Math.min(
                            colonySupply.get(i.getResource()) * secondsSinceLastUpdate + i.getQuantity(),
                            colony.getMaxResourceInventory()
                    )
            );
            i.setLastResourceInterrogation(now);
        });

        Map<String, Object> resources = new HashMap<>();
        colonyRepository.save(colony).getResourceInventories().forEach(i -> {
            resources.put(i.getResource().getName(), i.getQuantity().longValue());
        });

        return resources;
    }

}
