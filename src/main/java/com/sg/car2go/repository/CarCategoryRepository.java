package com.sg.car2go.repository;

import com.sg.car2go.model.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCategoryRepository extends JpaRepository<CarCategory, Long> {
}
