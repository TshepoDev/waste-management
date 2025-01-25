package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategory(WasteCategory wasteCategory);
}
