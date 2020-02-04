package com.impaler.astrolite.web;

import com.impaler.astrolite.model.combat.Ship;
import com.impaler.astrolite.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "ship")
public class ShipController {

    @Autowired
    private ShipService shipService;

    @PostMapping
    public ResponseEntity<Ship> createShip(@RequestBody Map<String, Object> data) {
        Ship ship = shipService.create(data);
        return new ResponseEntity<>(ship, ship != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
