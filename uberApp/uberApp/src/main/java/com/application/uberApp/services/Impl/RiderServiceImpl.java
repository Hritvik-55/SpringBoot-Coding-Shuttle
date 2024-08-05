package com.application.uberApp.services.Impl;

import com.application.uberApp.dto.DriverDTO;
import com.application.uberApp.dto.RideDTO;
import com.application.uberApp.dto.RideRequestDTO;
import com.application.uberApp.dto.RiderDTO;
import com.application.uberApp.entities.RideRequest;
import com.application.uberApp.entities.Rider;
import com.application.uberApp.entities.User;
import com.application.uberApp.entities.enums.RideRequestStatus;
import com.application.uberApp.repositories.RideRequestRepository;
import com.application.uberApp.repositories.RiderRepository;
import com.application.uberApp.services.RiderService;
import com.application.uberApp.strategies.DriverMatchingStartegy;
import com.application.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {
    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStartegy driverMatchingStartegy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    @Override
    public RideDTO cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDTO rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideRequestDTO requestRide(RideRequestDTO rideRequestDTO) {
        RideRequest rideRequest = modelMapper.map(rideRequestDTO, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        log.info(rideRequest.toString());
        double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);
        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);
        driverMatchingStartegy.findMatchingDrivers(rideRequest);
        return modelMapper.map(savedRideRequest,RideRequestDTO.class);
    }

    @Override
    public RiderDTO getMyProfile() {
        return null;
    }

    @Override
    public List<RideDTO> getAllMyRides() {
        return null;
    }

    @Override
    public Rider createNewRider(User savedUser) {
        Rider rider= Rider.builder()
                .user(savedUser)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
