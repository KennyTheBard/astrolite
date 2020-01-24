package com.impaler.astrolite.service;

import com.impaler.astrolite.repository.AttackFleetRepository;
import com.impaler.astrolite.repository.DefenceFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FleetService {

    @Autowired
    private AttackFleetRepository attackFleetRepository;

    @Autowired
    private DefenceFleetRepository defenceFleetRepository;

}
