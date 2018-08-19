package com.sg.car2go.controller;

import com.sg.car2go.exception.ResourceNotFoundException;
import com.sg.car2go.model.Location;
import com.sg.car2go.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/locations/{locationId}")
    public Location getLocation(@PathVariable Long locationId) {
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + locationId));
    }

    @PostMapping("/locations")
    public Location createLocation(@Valid @RequestBody Location locationRequest) {
        return locationRepository.save(locationRequest);
    }

}
