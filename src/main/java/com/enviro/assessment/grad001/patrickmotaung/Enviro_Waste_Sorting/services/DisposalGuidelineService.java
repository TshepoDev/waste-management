package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.CategoryNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.GuidelineNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.DisposalGuidelineRepo;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.WasteCategoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    private final DisposalGuidelineRepo disposalGuidelineRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    public DisposalGuidelineService(DisposalGuidelineRepo disposalGuidelineRepo, WasteCategoryRepo wasteCategoryRepo){
        this.disposalGuidelineRepo = disposalGuidelineRepo;
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    //Creates a Disposal Guideline for a Waste Category
    @Transactional
    public DisposalGuideline createDisposalGuideline(Long wasteCategoryId, DisposalGuideline disposalGuideline){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(wasteCategoryId));

        disposalGuideline.setWasteCategory(wasteCategory);
        return disposalGuidelineRepo.save(disposalGuideline);
    }

    //Retrieves all DisposalGuidelines by a specific id
    public DisposalGuideline findDisposalGuidelineById(Long id){
        return disposalGuidelineRepo.findById(id)
                .orElseThrow(()-> new GuidelineNotFoundException(id));
    }

    //Retrieves all DisposalGuidelines (potential improvements: use pagination)
    public List<DisposalGuideline> findAllDisposalGuidelines(){
        return disposalGuidelineRepo.findAll();
    }

    //Retrieves all DisposalGuidelines by a specified WasteCategory
    public List<DisposalGuideline> findDisposalGuidelinesByWasteCategory(Long wasteCategoryId){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(()-> new CategoryNotFoundException(wasteCategoryId));
        return disposalGuidelineRepo.findByWasteCategory(wasteCategory);
    }

    //Update Disposal Guideline
    public DisposalGuideline updateDisposalGuideline(Long id, DisposalGuideline disposalGuideline){
        DisposalGuideline updatedGuideline = findDisposalGuidelineById(id);

        updatedGuideline.setName(disposalGuideline.getName());
        updatedGuideline.setContent(disposalGuideline.getContent());
        updatedGuideline.setWasteCategory(disposalGuideline.getWasteCategory());

        return disposalGuidelineRepo.save(updatedGuideline);
    }

    //Delete disposal guideline
    public void deleteDisposalGuideline(Long id){
        if(!disposalGuidelineRepo.existsById(id)){
            throw new GuidelineNotFoundException(id);
        }
        disposalGuidelineRepo.deleteById(id);
    }

    //counts Disposal Guidelines for a specified Waste Category
    public Long countDisposalGuidelinesByCategory(Long wasteCategoryId){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(wasteCategoryId));
        return disposalGuidelineRepo.countByWasteCategory(wasteCategory);
    }





}
