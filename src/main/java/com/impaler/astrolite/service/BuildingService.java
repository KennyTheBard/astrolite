package com.impaler.astrolite.service;

import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public Building create(Map<String, Object> data) {
        Building building = Building.builder()
                .name((String) data.get("name"))
                .maxLevel(Integer.parseInt((String) data.get("maxLevel")))
                .build();

        return buildingRepository.save(building);
    }

}
