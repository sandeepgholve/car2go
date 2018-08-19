package com.sg.car2go.controller;

import com.sg.car2go.model.CarCategory;
import com.sg.car2go.repository.CarCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarCategoryController {

    @Autowired
    private CarCategoryRepository carCategoryRepository;

    @GetMapping("/categories/cars")
    public List<CarCategory> getCarCategories() {
        return carCategoryRepository.findAll();
    }
}
