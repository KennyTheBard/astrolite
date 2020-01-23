package com.impaler.astrolite.model.combat;

import com.impaler.astrolite.model.Player;

public interface IFleet {
    Long getId();
    Player getOwner();

    boolean defeated();
}
