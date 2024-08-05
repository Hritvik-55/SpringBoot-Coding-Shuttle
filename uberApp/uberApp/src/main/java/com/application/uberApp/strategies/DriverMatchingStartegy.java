package com.application.uberApp.strategies;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideRequestDTO;

import java.util.List;

public interface DriveMatchingStartegy {
    List<DriverDTO> findMatchingDrivers(RideRequestDTO rideRequestDTO);
}
