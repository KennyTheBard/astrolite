package com.impaler.astrolite.service;

import com.impaler.astrolite.model.colony.Colony;
import com.impaler.astrolite.model.resource.Resource;
import com.impaler.astrolite.repository.ColonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
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

        Map<Resource, Integer> colonySupply = new HashMap<>();
        colony.getResourceProductions().forEach(p -> {
            colonySupply.put(p.getResource(), p.getProductionPerHour());
        });

        colony.getResourceInventories().forEach(i -> {
            double percentOfHour = ((double) Duration.between(i.getLastResourceInterrogation(), now).getSeconds()) / 3600;
            double addedValue = colonySupply.get(i.getResource()) * percentOfHour;
            i.setQuantity(
                    Math.min(
                            Double.valueOf(Math.floor(addedValue) + i.getQuantity()).intValue(),
                            colony.getMaxResourceInventory()
                    )
            );
            i.setLastResourceInterrogation(i.getLastResourceInterrogation().plus((long) (Math.floor(addedValue) * 3600 / colonySupply.get(i.getResource()) * 1000), ChronoField.MILLI_OF_DAY.getBaseUnit()));
        });

        Map<String, Object> resources = new HashMap<>();
        colonyRepository.save(colony).getResourceInventories().forEach(i -> {
            resources.put(i.getResource().getName(), i.getQuantity());
            resources.put(i.getResource().getName() + " last update", i.getLastResourceInterrogation());
        });

        return resources;
    }

}
