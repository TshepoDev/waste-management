package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepo extends JpaRepository<WasteCategory, Long> {
}
