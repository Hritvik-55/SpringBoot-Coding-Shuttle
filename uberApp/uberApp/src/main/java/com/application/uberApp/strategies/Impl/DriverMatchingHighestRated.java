package com.application.uberApp.strategies.Impl;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideRequestDTO;
import com.application.uberApp.entities.Driver;
import com.application.uberApp.entities.RideRequest;
import com.application.uberApp.strategies.DriverMatchingStartegy;

import java.util.List;

public class DriverMatchingHighestRated implements DriverMatchingStartegy {
    @Override
    public List<Driver> findMatchingDrivers(RideRequest rideRequest) {
        return null;
    }
}
