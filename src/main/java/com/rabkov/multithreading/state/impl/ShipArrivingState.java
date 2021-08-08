package com.rabkov.multithreading.state.impl;

import com.rabkov.multithreading.entity.Pier;
import com.rabkov.multithreading.entity.Port;
import com.rabkov.multithreading.entity.Ship;
import com.rabkov.multithreading.exception.MultiException;
import com.rabkov.multithreading.state.ShipState;

import java.util.Optional;

public class ShipArrivingState implements ShipState {
    @Override
    public void doAction(Ship ship) throws MultiException {
        Port port = Port.getInstance();
        Pier pier = port.getPier();
        ship.setPier(Optional.of(pier));
        switch (ship.getShipTarget()){
            case LOADING -> ship.setShipState(new ShipLoadingState());
            case UNLOADING, LOADING_UNLOADING -> ship.setShipState(new ShipUnloadingState());
        }
    }
}