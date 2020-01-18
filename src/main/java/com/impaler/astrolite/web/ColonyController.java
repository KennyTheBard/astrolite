package com.impaler.astrolite.web;

import com.impaler.astrolite.service.ColonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ColonyController {

    @Autowired
    private ColonyService colonyService;

    @GetMapping(value = "/resources/{id}")
    public Map<String, Object> getResources(@PathVariable Long id) {
        return colonyService.interrogateResource(id);
    }

}
