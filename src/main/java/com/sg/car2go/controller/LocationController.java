package com.sg.car2go.controller;

import com.sg.car2go.model.Location;
import com.sg.car2go.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }
}
