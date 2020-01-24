package com.impaler.astrolite.web;

import com.impaler.astrolite.model.base.SolarSystem;
import com.impaler.astrolite.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "solar-system")
public class SolarSystemController {

    @Autowired
    private SolarSystemService solarSystemService;

    @PostMapping
    public ResponseEntity<SolarSystem> createSolarSystem(@RequestBody Map<String, Object> data) {
        SolarSystem solarSystem = solarSystemService.create(data);
        return new ResponseEntity<>(solarSystem, solarSystem != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
