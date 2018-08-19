package com.sg.car2go.controller;

import com.sg.car2go.exception.ResourceNotFoundException;
import com.sg.car2go.model.*;
import com.sg.car2go.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarCategoryRepository carCategoryRepository;

    @Autowired
    private LocationRepository locationRepository;

    /**
     * List all cars (with pagination support)
     *
     * @param pageable pagination information
     * @return List of Cars for given Page as per pagination input
     */
    @GetMapping("/cars")
    public Page<Car> getCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @GetMapping("/cars/{carId}")
    public Car getCar(@PathVariable Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    /**
     * Create new car
     * @param carRequest Car request object
     * @return Created car
     */
    @PostMapping("/cars")
    public Car createCar(@Valid @RequestBody Car carRequest) {
        return carRepository.save(carRequest);
    }

    /**
     * Update car information (excluding its current location or category)
     *
     * @param carId      Car Id
     * @param carRequest Car Request Body
     * @return Updated Car Object.
     */
    @PutMapping("/cars/{carId}")
    public Car updateCar(@PathVariable Long carId, @Valid @RequestBody Car carRequest) {
        return carRepository.findById(carId)
                .map(car -> {
                    car.setBrand(carRequest.getBrand());
                    car.setColor(carRequest.getColor());
                    car.setMileage(carRequest.getMileage());
                    car.setModel(carRequest.getModel());
                    car.setProductionYear(carRequest.getProductionYear());
                    return carRepository.save(car);
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    /**
     * Delete car
     *
     * @param carId car id
     * @return http response with success or error information
     */
    @DeleteMapping("/cars/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    carRepository.delete(car);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    @GetMapping("/cars/{carId}/location")
    public Location getCarLocation(@PathVariable Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));

        if (car.getCurrentLocation() != null) {
            return car.getCurrentLocation();
        } else {
            throw new ResourceNotFoundException("Car not yet registered to any location");
        }
    }

    /**
     * Update Car Location
     *
     * @param carId      Car Id
     * @param locationId Location Id
     * @return http response with success or error information
     */
    @PutMapping("/cars/{carId}/location/{locationId}")
    public ResponseEntity<?> updateCarLocation(@PathVariable Long carId, @PathVariable Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + locationId));

        return carRepository.findById(carId)
                .map(car -> {
                    car.setCurrentLocation(location);
                    carRepository.save(car);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    /**
     * De-register the car from its current location.
     * @param carId Car Id
     * @return http response with success or error information
     */
    @DeleteMapping("/cars/{carId}/location")
    public ResponseEntity<?> deleteCarLocation(@PathVariable Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    car.setCurrentLocation(null);
                    carRepository.save(car);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    /**
     * Retrieve the Car Category
     *
     * @param carId Car Id
     * @return Car Category
     */
    @GetMapping("/cars/{carId}/category")
    public CarCategory getCarCategory(@PathVariable Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));

        if (car.getCategory() != null) {
            return car.getCategory();
        } else {
            throw new ResourceNotFoundException("Car not yet registered to any category");
        }
    }

    /**
     * Update Car Category
     *
     * @param carId      Car Id
     * @param categoryId category Id
     * @return http response with success or error information
     */
    @PutMapping("/cars/{carId}/category/{categoryId}")
    public ResponseEntity<?> updateCarCategory(@PathVariable Long carId, @PathVariable Long categoryId) {
        CarCategory carCategory = carCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Car category not found with id " + categoryId));

        return carRepository.findById(carId)
                .map(car -> {
                    car.setCategory(carCategory);
                    carRepository.save(car);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }

    /**
     * De-register the car from its current category.
     * @param carId Car Id
     * @return http response with success or error information
     */
    @DeleteMapping("/cars/{carId}/category")
    public ResponseEntity<?> deleteCarCategory(@PathVariable Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    car.setCategory(null);
                    carRepository.save(car);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + carId));
    }
}
