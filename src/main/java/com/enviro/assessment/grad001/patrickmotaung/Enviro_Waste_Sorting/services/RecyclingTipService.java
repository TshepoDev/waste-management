package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.CategoryNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.TipNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.RecyclingTip;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.RecyclingTipRepo;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.WasteCategoryRepo;
import jakarta.transaction.Transactional;

import java.util.List;

public class RecyclingTipService {
    private final RecyclingTipRepo recyclingTipRepo;
    private final WasteCategoryRepo wasteCategoryRepo;

    public RecyclingTipService(RecyclingTipRepo  recyclingTipRepo, WasteCategoryRepo wasteCategoryRepo){
        this.recyclingTipRepo =  recyclingTipRepo;
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    //Creates a recycling tip for a specified waste category
    @Transactional
    public RecyclingTip createRecyclingTip(Long wasteCategoryId, RecyclingTip recyclingTip){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(wasteCategoryId));

        recyclingTip.setWasteCategory(wasteCategory);
        return recyclingTipRepo.save(recyclingTip);
    }

    //Retrieves Recycling Tips for a specified id
    public RecyclingTip findRecyclingTipById(Long id){
        return recyclingTipRepo.findById(id)
                .orElseThrow(()-> new TipNotFoundException(id));
    }

    //Retrieves all Recycling Tips (potential improvements: use pagination)
    public List<RecyclingTip> findAllRecyclingTips(){
        return recyclingTipRepo.findAll();
    }

    //Retrieves all Recycling Tips for a specified Waste Category
    public List<RecyclingTip> findRecyclingTipsByWasteCategory(Long wasteCategoryId){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(()-> new CategoryNotFoundException(wasteCategoryId));

        return recyclingTipRepo.findByWasteCategory(wasteCategory);
    }

    //Update a Recycling Tip
    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip){
        RecyclingTip updatedRecyclingTip = findRecyclingTipById(id);

        updatedRecyclingTip.setTitle(recyclingTip.getTitle());
        updatedRecyclingTip.setContent(recyclingTip.getContent());
        updatedRecyclingTip.setWasteCategory(recyclingTip.getWasteCategory());

        return recyclingTipRepo.save(updatedRecyclingTip);
    }

    //Delete recycling tip
    public void deleteRecyclingTip(Long id){
        if(!recyclingTipRepo.existsById(id)){
            throw new TipNotFoundException(id);
        }
        recyclingTipRepo.deleteById(id);
    }

    //counts recycling tips for a specified waste category
    public Long countRecyclingTipsByCategory(Long wasteCategoryId){
        WasteCategory wasteCategory = wasteCategoryRepo.findById(wasteCategoryId)
                .orElseThrow(() -> new CategoryNotFoundException(wasteCategoryId));
        return recyclingTipRepo.countByWasteCategory(wasteCategory);
    }

}
