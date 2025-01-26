package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions.CategoryNotFoundException;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.repositories.WasteCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

    private final WasteCategoryRepo wasteCategoryRepo;

    public WasteCategoryService(WasteCategoryRepo wasteCategoryRepo){
        this.wasteCategoryRepo = wasteCategoryRepo;
    }

    public List<WasteCategory> findAllCategories(){
        return wasteCategoryRepo.findAll();
    }

    public WasteCategory findCategoryById(Long id){
        return wasteCategoryRepo.findById(id)
                .orElseThrow(()->new CategoryNotFoundException(id));
    }

    public WasteCategory addWasteCategory(WasteCategory wasteCategory){
        return wasteCategoryRepo.save(wasteCategory);
    }


    public WasteCategory updateWasteCategory(Long id, WasteCategory updatedCategory){
        WasteCategory existingCategory = findCategoryById(id);//will throw exception when waste category is not found
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());

        return wasteCategoryRepo.save(existingCategory);
    }

    public void deleteWasteCategory(Long id){
        if(!wasteCategoryRepo.existsById(id)){
            throw new CategoryNotFoundException(id);
        }
        wasteCategoryRepo.deleteById(id);
    }
}
