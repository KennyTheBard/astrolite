package com.impaler.astrolite.service;

import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.model.base.SolarSystem;
import com.impaler.astrolite.model.base.SolarSystemResourceModifier;
import com.impaler.astrolite.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
