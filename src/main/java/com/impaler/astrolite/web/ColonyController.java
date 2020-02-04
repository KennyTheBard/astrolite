package com.impaler.astrolite.web;

import com.impaler.astrolite.model.base.Colony;
import com.impaler.astrolite.service.ColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "colony")
public class ColonyController {

    @Autowired
    private ColonyService colonyService;

    @PostMapping
    public ResponseEntity<Colony> createColony(@RequestBody Map<String, Object> data) {
        Colony colony = colonyService.create(data);
        return new ResponseEntity<>(colony, colony != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Colony> changeColonyName(@PathVariable Long id, @RequestBody String newName) {
        Colony colony = colonyService.updateName(id, newName);
        return new ResponseEntity<>(colony, colony != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

//    @PutMapping("/{id}/build/{buildingId}")
//    public ResponseEntity<Colony> build(@PathVariable Long id, @PathVariable Long buildingId) {
//        Colony colony = colonyService.build(id, buildingId);
//        return new ResponseEntity<>(colony, colony != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
//    }

}
