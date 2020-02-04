package com.impaler.astrolite.service;

import com.impaler.astrolite.model.base.ColonyResourceInventory;
import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.model.base.SolarSystem;
import com.impaler.astrolite.model.base.SolarSystemResourceModifier;
import com.impaler.astrolite.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<SolarSystemResourceModifier> basicModifiers() {
        return resourceRepository.findAll().stream()
                .map(r -> SolarSystemResourceModifier.builder()
                        .resource(r)
                        .value(1f)
                        .build())
                .collect(Collectors.toList());
    }

    public List<ColonyResourceInventory> basicInventories() {
        LocalDateTime now = LocalDateTime.now();
        return resourceRepository.findAll().stream()
                .map(r -> ColonyResourceInventory.builder()
                        .resource(r)
                        .quantity(0f)
                        .lastResourceInterrogation(now)
                        .build())
                .collect(Collectors.toList());
    }


    public Resource create(String name) {
        Resource resource = Resource.builder().name(name).build();

        return resourceRepository.save(resource);
    }
}
