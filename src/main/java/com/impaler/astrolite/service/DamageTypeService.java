package com.impaler.astrolite.service;

import com.impaler.astrolite.model.combat.DamageType;
import com.impaler.astrolite.repository.DamageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DamageTypeService {

    @Autowired
    private DamageTypeRepository damageTypeRepository;

    public DamageType create(Map<String, Object> data) {
        DamageType damageType = DamageType.builder()
                .name((String) data.get("name"))
                .build();

        return damageTypeRepository.save(damageType);
    }
}
