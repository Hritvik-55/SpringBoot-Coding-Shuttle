package com.application.uberApp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rating;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Boolean available;
    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point currentLocation;
}
