package com.impaler.astrolite.service;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.model.base.SolarSystem;
import com.impaler.astrolite.model.base.SolarSystemResourceModifier;
import com.impaler.astrolite.model.combat.DamageType;
import com.impaler.astrolite.model.combat.DefensiveStats;
import com.impaler.astrolite.model.combat.OffensiveStats;
import com.impaler.astrolite.model.combat.Ship;
import com.impaler.astrolite.repository.BuildingRepository;
import com.impaler.astrolite.repository.DamageTypeRepository;
import com.impaler.astrolite.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShipService {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private DamageTypeRepository damageTypeRepository;

    public Ship create(Map<String, Object> data) {
        Optional<Building> optionalBuilding = buildingRepository.findById(Long.parseLong((String) data.get("buildAt")));
        if (!optionalBuilding.isPresent()) {
            return null;
        }

        Ship ship = Ship.builder()
                .name((String) data.get("name"))
                .travelSpeed(Integer.valueOf((String) data.get("travelSpeed")))
                .health(Integer.valueOf((String) data.get("health")))
                .inventory(Integer.valueOf((String) data.get("inventory")))
                .buildAt(optionalBuilding.get())
                .buildTimeInSec(Integer.valueOf((String) data.get("buildTimeInSec")))
                .build();

        List<OffensiveStats> offensiveStats = new ArrayList<>();
        if (data.containsKey("offensiveStats")) {
            ((List<Map<String, Object>>) data.get("offensiveStats")).forEach(dataMap -> {
                OffensiveStats offensive = OffensiveStats.builder()
                        .attackDamage(Integer.valueOf((String) dataMap.get("attackDamage")))
                        .attackSpeed(Integer.valueOf((String) dataMap.get("attackSpeed")))
                        .build();

                Optional<DamageType> optionalDamageType = damageTypeRepository.findById(Long.valueOf((String) dataMap.get("damageType")));
                if (!optionalDamageType.isPresent()) {
                    throw new EntityNotFoundException("Damage type not found");
                }

                offensive.setDamageType(optionalDamageType.get());
                offensiveStats.add(offensive);
            });
        }
        ship.setOffensiveStats(offensiveStats);
        offensiveStats.forEach(s -> s.setOwner(ship));

        List<DefensiveStats> defensiveStats = new ArrayList<>();
        if (data.containsKey("defensiveStats")) {
            ((List<Map<String, Object>>) data.get("defensiveStats")).forEach(dataMap -> {
                DefensiveStats defensive = DefensiveStats.builder()
                        .armor(Integer.valueOf((String) dataMap.get("armor")))
                        .build();

                Optional<DamageType> optionalDamageType = damageTypeRepository.findById(Long.valueOf((String) dataMap.get("damageType")));
                if (!optionalDamageType.isPresent()) {
                    throw new EntityNotFoundException("Damage type not found");
                }

                defensive.setAgainst(optionalDamageType.get());
                defensiveStats.add(defensive);
            });
        }
        ship.setDefensiveStats(defensiveStats);
        defensiveStats.forEach(s -> s.setOwner(ship));

        return shipRepository.save(ship);
    }

    public Map<String, Object> getDefence() {
        Map<String, Object> stats = new HashMap<>();
        shipRepository.findAll().forEach(ship -> {
            stats.put(ship.getName(), ship.getDefensiveStats().stream()
                    .collect(
                            Collectors.toMap(
                                    def -> def.getAgainst().getName(),
                                    def -> def.getArmor()
                            )
                    )
            );
        });
        return stats;
    }

}
