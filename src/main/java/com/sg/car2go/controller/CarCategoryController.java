package com.sg.car2go.controller;

import com.sg.car2go.exception.ResourceNotFoundException;
import com.sg.car2go.model.CarCategory;
import com.sg.car2go.model.Location;
import com.sg.car2go.repository.CarCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarCategoryController {

    @Autowired
    private CarCategoryRepository carCategoryRepository;

    @GetMapping("/categories/cars")
    public List<CarCategory> getCarCategories() {
        return carCategoryRepository.findAll();
    }

    @PostMapping("/categories/cars")
    public CarCategory createCarCategory(@Valid @RequestBody CarCategory carCategoryRequest) {
        return carCategoryRepository.save(carCategoryRequest);
    }

    @GetMapping("/categories/cars/{categoryId}")
    public CarCategory getCarCategory(@PathVariable Long categoryId) {
        return carCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Car category not found with categoryId " + categoryId));
    }

}
