package com.application.uberApp.strategies.Impl;

import com.application.uberApp.dto.RideRequestDTO;
import com.application.uberApp.entities.RideRequest;
import com.application.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgeFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
