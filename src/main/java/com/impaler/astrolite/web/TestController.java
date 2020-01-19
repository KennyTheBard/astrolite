package com.impaler.astrolite.web;

import com.impaler.astrolite.service.ColonyService;
import com.impaler.astrolite.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private ColonyService colonyService;

    @Autowired
    private ShipService shipService;

    @GetMapping(value = "/resources/{id}")
    public Map<String, Object> getResources(@PathVariable Long id) {
        return colonyService.interrogateResource(id);
    }

    @GetMapping(value = "/defence")
    public Map<String, Object> getResources() {
        return shipService.getDefence();
    }

}
