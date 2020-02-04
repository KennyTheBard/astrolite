package com.impaler.astrolite.service;

import com.impaler.astrolite.model.Player;
import com.impaler.astrolite.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player create(Map<String, Object> data) {
        Player player = Player.builder()
                .name((String) data.get("name"))
                .build();

        return playerRepository.save(player);
    }

}
