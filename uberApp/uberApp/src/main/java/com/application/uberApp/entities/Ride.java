package com.application.uberApp.entities;

import com.application.uberApp.entities.enums.PaymentMethod;
import com.application.uberApp.entities.enums.RideRequestStatus;
import com.application.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;
    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;
    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point pickupLocation;
    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point dropOffLocaion;
    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;
    @CreationTimestamp
    private LocalDateTime createdTime;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Double fare;
    private String otp;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
