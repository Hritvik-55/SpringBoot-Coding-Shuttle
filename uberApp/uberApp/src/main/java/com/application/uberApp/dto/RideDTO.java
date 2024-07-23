package com.application.uberApp.dto;

import com.application.uberApp.entities.Driver;
import com.application.uberApp.entities.Rider;
import com.application.uberApp.entities.enums.PaymentMethod;
import com.application.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDTO {

    private Long id;

    private RiderDTO rider;
    private DriverDTO driver;
    private Point pickupLocation;
    private Point dropOffLocaion;
    private RideStatus rideStatus;

    private LocalDateTime createdTime;
    private PaymentMethod paymentMethod;
    private Double fare;
    private String otp;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
