package com.rabkov.multithreading.state;

import com.rabkov.multithreading.entity.Ship;
import com.rabkov.multithreading.exception.MultiException;

public interface ShipState {
    void doAction(Ship ship) throws MultiException;
}
