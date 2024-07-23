package com.application.uberApp.strategies.Impl;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideRequestDTO;
import com.application.uberApp.strategies.DriveMatchingStartegy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriverMatchingNearestDriver implements DriveMatchingStartegy {
    @Override
    public List<DriverDTO> findMatchingDrivers(RideRequestDTO rideRequestDTO) {
        return null;
    }
}
