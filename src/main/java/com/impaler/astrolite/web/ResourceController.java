package com.impaler.astrolite.web;

import com.impaler.astrolite.model.base.Resource;
import com.impaler.astrolite.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping()
    public ResponseEntity<Resource> createResource(@RequestBody String name) {
        Resource resource = resourceService.create(name);
        return new ResponseEntity<>(resource, resource != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
