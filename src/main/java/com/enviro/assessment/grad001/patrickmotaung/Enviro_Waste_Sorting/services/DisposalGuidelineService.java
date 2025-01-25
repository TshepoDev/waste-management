package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.GuidelineNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.WasteCategoryRepo;

import java.util.List;

public class DisposalGuidelineService {
    private final DisposalGuidelineRepo disposalGuidelineRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    public DisposalGuidelineService(DisposalGuidelineRepo disposalGuidelineRepo, WasteCategoryRepo wasteCategoryRepo){
        this.disposalGuidelineRepo = disposalGuidelineRepo;
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    public List<DisposalGuideline> getDisposalGuidelinesByWasteCategory(Long wasteCategoryId){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(()-> new GuidelineNotFoundException(wasteCategoryId));
        return disposalGuidelineRepo.findByWasteCategory(wasteCategory);
    }

    public List<DisposalGuideline> findAllDisposalGuidelines(){
        return disposalGuidelineRepo.findAll();
    }

    public DisposalGuideline findDisposalGuidelineById(Long id){
        return disposalGuidelineRepo.findById(id)
                .orElseThrow(()-> new GuidelineNotFoundException(id));
    }

    public DisposalGuideline addDisposalGuideline(DisposalGuideline disposalGuideline){
        return disposalGuidelineRepo.save(disposalGuideline);
    }

    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline disposalGuideline){
        DisposalGuideline updatedGuideline = findDisposalGuidelineById(id);

        updatedGuideline.setName(disposalGuideline.getName());
        updatedGuideline.setContent(disposalGuideline.getContent());
        updatedGuideline.setWasteCategory(disposalGuideline.getWasteCategory());

        return disposalGuidelineRepo.save(updatedGuideline);
    }

    public void deleteDisposalGuideline(Long id){
        if(!disposalGuidelineRepo.existsById(id)){
            throw new GuidelineNotFoundException(id);
        }
        disposalGuidelineRepo.deleteById(id);
    }
}
