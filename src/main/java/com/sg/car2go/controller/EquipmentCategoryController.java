package com.sg.car2go.controller;

import com.sg.car2go.model.EquipmentCategory;
import com.sg.car2go.repository.EquipmentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentCategoryController {

    @Autowired
    private EquipmentCategoryRepository equipmentCategoryRepository;

    @GetMapping("/categories/equipments")
    public List<EquipmentCategory> getCarEquipments() {
        return equipmentCategoryRepository.findAll();
    }
}
