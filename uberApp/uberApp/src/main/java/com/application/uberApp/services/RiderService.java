package com.application.uberApp.services;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideDTO;
import com.application.uberApp.dto.RideRequestDTO;
import com.application.uberApp.dto.RiderDTO;

import java.util.List;

public interface RiderService {
    RideDTO cancelRide(Long rideId);
 DriverDTO rateDriver(Long rideId, Integer rating);
    RideRequestDTO requestRide(RideRequestDTO rideRequestDTO);
    RiderDTO getMyProfile();
    List<RideDTO> getAllMyRides();
}
