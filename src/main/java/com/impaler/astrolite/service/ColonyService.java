package com.impaler.astrolite.service;

import com.impaler.astrolite.model.colony.Colony;
import com.impaler.astrolite.repository.ColonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ColonyService {

    @Autowired
    private ColonyRepository colonyRepository;

    public Map<String, Integer> interrogateResource(Long id) {
        Colony colony = colonyRepository.getColonyById(id);
        LocalDateTime now = LocalDateTime.now();
        double workedTime = ((double) Duration.between(colony.getLastResourceInterrogation(), now).getSeconds()) / 3600;

        colony.setOre(
                Math.min(
                        Double.valueOf(colony.getOrePerHour() * workedTime + colony.getOre()).intValue(),
                        colony.getMaxResourceStorage()
                )
        );
        colony.setCarbonite(
                Math.min(
                        Double.valueOf(colony.getCarbonitePerHour() * workedTime + colony.getCarbonite()).intValue(),
                        colony.getMaxResourceStorage()
                )
        );
        colony.setUranium(
                Math.min(
                        Double.valueOf(colony.getUraniumPerHour() * workedTime + colony.getUranium()).intValue(),
                        colony.getMaxResourceStorage()
                )
        );
        colony.setLastResourceInterrogation(now);

        colony = colonyRepository.save(colony);

        Map<String, Integer> resources = new HashMap<>();
        resources.put("ore", colony.getOre());
        resources.put("carbonite", colony.getCarbonite());
        resources.put("uranium", colony.getUranium());

        return resources;
    }

}
