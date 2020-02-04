package com.impaler.astrolite.web;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Map<String, Object> data) {
        Player player = playerService.create(data);
        return new ResponseEntity<>(player, player != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
