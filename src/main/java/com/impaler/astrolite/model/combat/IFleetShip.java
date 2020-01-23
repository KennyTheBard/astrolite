package com.impaler.astrolite.model.combat;

public interface IFleetShip {
    Ship getShip();
    IFleet getFleet();
    Integer getQuantity();


    void destroyShips(int numberOfShipsToDestroy);
}
