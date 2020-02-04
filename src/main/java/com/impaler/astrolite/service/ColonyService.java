package com.impaler.astrolite.service;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.base.*;
import com.impaler.astrolite.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ColonyService {

    @Autowired
    private ColonyRepository colonyRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ColonyBuildingRepository colonyBuildingRepository;

    public Colony create(Map<String, Object> data) {
        Optional<Player> optionalPlayer = playerRepository.findById(Long.parseLong((String) data.get("player")));
        Optional<SolarSystem> optionalSolarSystem = solarSystemRepository.findById(Long.parseLong((String) data.get("solarSystem")));
        if (!optionalPlayer.isPresent() || !optionalSolarSystem.isPresent()) {
            return null;
        }

        Player player = optionalPlayer.get();
        SolarSystem solarSystem = optionalSolarSystem.get();

        Colony colony = Colony.builder()
                .name(solarSystem.getName())
                .owner(player)
                .solarSystem(solarSystem)
                .maxResourceInventory(1000)
                .build();

        List<ColonyResourceInventory> inventories = resourceService.basicInventories();

        colony.setResourceInventories(inventories);
        inventories.forEach(i -> i.setColony(colony));

        return colonyRepository.save(colony);
    }

    public Colony updateName(Long id, String newName) {
        Optional<Colony> optionalColony = colonyRepository.findById(id);
        if (!optionalColony.isPresent()) {
            return null;
        }

        Colony colony = optionalColony.get();
        colony.setName(newName);
        return colonyRepository.save(colony);
    }

    public Map<String, Object> interrogateResource(Long id) {
        Optional<Colony> optionalColony = colonyRepository.findById(id);
        if (!optionalColony.isPresent()) {
            return null;
        }

        final Colony colony = optionalColony.get();
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

//    public Colony build(Long id, Long buildingId) {
//        Optional<Colony> optionalColony = colonyRepository.findById(id);
//        Optional<Building> optionalBuilding = buildingRepository.findById(buildingId);
//        if (!optionalColony.isPresent() || !optionalBuilding.isPresent()) {
//            return null;
//        }
//
//        Colony colony = optionalColony.get();
//        Building building = optionalBuilding.get();
//
//        Optional<ColonyBuilding> optionalColonyBuilding = colonyBuildingRepository.findOneByColonyAndBuilding(colony, building);
//        ColonyBuilding colonyBuilding;
//        if (optionalColonyBuilding.isPresent()) {
//            colonyBuilding = optionalColonyBuilding.get();
//            colony
//        }
//    }
}
