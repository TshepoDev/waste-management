package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.controllers;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/waste-categories")
public class WasteCategoryController {

    @Autowired
    private final WasteCategoryService wasteCategoryService;

    public WasteCategoryController(WasteCategoryService wasteCategoryService){
        this.wasteCategoryService = wasteCategoryService;
    }


    @GetMapping()
    public ResponseEntity<List<WasteCategory>> getAllCategories(){
        List<WasteCategory> categories = wasteCategoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> findWasteCategoryById(@PathVariable Long id){
        WasteCategory wasteCategory = wasteCategoryService.findCategoryById(id);
        return ResponseEntity.ok(wasteCategory);
    }

    @PostMapping()
    public ResponseEntity<WasteCategory> addWasteCategory(@Valid @RequestBody WasteCategory wasteCategory){
        WasteCategory newWasteCategory = wasteCategoryService.addWasteCategory(wasteCategory);
        return ResponseEntity.created(URI.create("/waste-categories/" + newWasteCategory.getId())).body(newWasteCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable  Long id,@Valid @RequestBody WasteCategory wasteCategory){
        WasteCategory updatedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return ResponseEntity.ok(updatedWasteCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategoryById(@PathVariable Long id){
        wasteCategoryService.deleteWasteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
