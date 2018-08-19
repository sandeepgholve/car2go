package com.sg.car2go.controller;

import com.sg.car2go.exception.ResourceNotFoundException;
import com.sg.car2go.model.EquipmentCategory;
import com.sg.car2go.repository.EquipmentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EquipmentCategoryController {

    @Autowired
    private EquipmentCategoryRepository equipmentCategoryRepository;

    @GetMapping("/categories/equipments")
    public List<EquipmentCategory> getCarEquipments() {
        return equipmentCategoryRepository.findAll();
    }

    @PostMapping("/categories/equipments")
    public EquipmentCategory createCarEquipment(@Valid @RequestBody EquipmentCategory equipmentCategoryRequest) {
        return equipmentCategoryRepository.save(equipmentCategoryRequest);
    }

    @GetMapping("/categories/equipments/{categoryId}")
    public EquipmentCategory getEquipmentCategory(@PathVariable Long categoryId) {
        return equipmentCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment category not found with categoryId " + categoryId));
    }

}
