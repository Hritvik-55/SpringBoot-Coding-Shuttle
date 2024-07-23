package com.application.uberApp.services;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideDTO;
import com.application.uberApp.dto.RiderDTO;
import com.application.uberApp.entities.Driver;

import java.util.List;

public interface DriverService {
    RideDTO cancelRide(Long rideId);
    RideDTO startRide(Long rideId);
    RideDTO endRide(Long rideId);
    RiderDTO rateRider(Long rideId,Integer rating);
    RideDTO acceptRide(Long rideId);
    DriverDTO getMyProfile();
    List<RideDTO> getAllMyRides();

}
