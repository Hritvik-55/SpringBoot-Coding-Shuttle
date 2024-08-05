package com.application.uberApp.services.Impl;

import com.application.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceORSMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point destination) {
        return 0;
    }
}
