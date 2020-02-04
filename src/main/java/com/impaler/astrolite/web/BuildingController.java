package com.impaler.astrolite.web;

import com.impaler.astrolite.model.base.Building;
import com.impaler.astrolite.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public ResponseEntity<Building> createBuilding(@RequestBody Map<String, Object> data) {
        Building building = buildingService.create(data);
        return new ResponseEntity<>(building, building != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}