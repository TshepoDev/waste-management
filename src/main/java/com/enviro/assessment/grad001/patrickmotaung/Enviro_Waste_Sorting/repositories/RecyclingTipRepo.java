package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.RecyclingTip;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecyclingTipRepo extends JpaRepository<RecyclingTip, Long> {
    List<RecyclingTip> findByWasteCategory(WasteCategory wasteCategory);
    Long countByWasteCategory(WasteCategory wasteCategory);
}
