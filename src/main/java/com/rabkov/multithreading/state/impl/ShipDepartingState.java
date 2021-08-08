package com.rabkov.multithreading.state.impl;

import com.rabkov.multithreading.entity.Pier;
import com.rabkov.multithreading.entity.Port;
import com.rabkov.multithreading.entity.Ship;
import com.rabkov.multithreading.exception.MultiException;
import com.rabkov.multithreading.state.ShipState;

import java.util.Optional;

public class ShipDepartingState implements ShipState {
    @Override
    public void doAction(Ship ship) throws MultiException {
        Port port = Port.getInstance();
        Optional<Pier> pier = ship.getPier();
        if (pier.isPresent()) {
            port.releasePier(pier.get());
            ship.setPier(Optional.empty());
        }
        ship.setShipState(new ShipArrivingState());
    }
}
