package com.impaler.astrolite.service;

import com.impaler.astrolite.model.base.SolarSystem;
import com.impaler.astrolite.model.base.SolarSystemResourceModifier;
import com.impaler.astrolite.repository.SolarSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SolarSystemService {

    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Autowired
    private ResourceService resourceService;

    public SolarSystem create(Map<String, Object> data) {
        SolarSystem solarSystem = SolarSystem.builder()
                .name((String) data.get("name"))
                .angleToCore((Integer) data.getOrDefault("angleToCore", 0))
                .distanceToCore((Integer) data.getOrDefault("distanceToCore", 0))
                .build();

        List<SolarSystemResourceModifier> modifiers = resourceService.basicModifiers();

        if (data.containsKey("modifiers")) {
            ((List<Map<String, Object>>) data.get("modifiers")).forEach(dataMap ->
                    modifiers.forEach(modifier -> {
                        if (modifier.getResource().getName().equalsIgnoreCase(String.valueOf(dataMap.get("resource")))) {
                            modifier.setValue((float) ((double) dataMap.getOrDefault("value", 1.0)));
                        }
                    })
            );
        }

        solarSystem.setModifiers(modifiers);
        modifiers.forEach(m -> m.setSolarSystem(solarSystem));

        return solarSystemRepository.save(solarSystem);
    }

}
