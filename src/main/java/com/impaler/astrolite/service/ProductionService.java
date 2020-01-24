package com.impaler.astrolite.service;

import com.impaler.astrolite.repository.ResearchProductionRepository;
import com.impaler.astrolite.repository.ShipProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionService {

    @Autowired
    private ResearchProductionRepository researchProductionRepository;

    @Autowired
    private ShipProductionRepository shipProductionRepository;

}
