package com.rabkov.multithreading.state.impl;

import com.rabkov.multithreading.entity.Pier;
import com.rabkov.multithreading.entity.Port;
import com.rabkov.multithreading.entity.Ship;
import com.rabkov.multithreading.exception.MultiException;
import com.rabkov.multithreading.state.ShipState;

import java.util.Optional;

public class ShipLoadingState implements ShipState {
    @Override
    public void doAction(Ship ship) throws MultiException {
        Port port = Port.getInstance();
        Optional<Pier> pier = ship.getPier();
        if (((Optional<?>) pier).isPresent()) {
            port.loadShip(ship);
        }
        ship.setShipState(new ShipDepartingState());
    }
}
