package com.impaler.astrolite.web;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.model.combat.DamageType;
import com.impaler.astrolite.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "damage-type")
public class DamageTypeController {

    @Autowired
    private DamageTypeService damageTypeService;

    @PostMapping
    public ResponseEntity<DamageType> createDamageType(@RequestBody Map<String, Object> data) {
        DamageType damageType = damageTypeService.create(data);
        return new ResponseEntity<>(damageType, damageType != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
