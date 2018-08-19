package com.sg.car2go.controller;

import com.sg.car2go.model.Car;
import com.sg.car2go.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public Page<Car> getCars(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
