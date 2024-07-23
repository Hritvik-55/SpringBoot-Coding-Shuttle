package com.application.uberApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private UserDTO userDTO;
    private Double rating;
}
