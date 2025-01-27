package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.controllers;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.WasteCategory;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services.DisposalGuidelineService;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disposal-guidelines")

public class DisposalGuidelineController {
    @Autowired
    private final DisposalGuidelineService disposalGuidelineService;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService){
        this.disposalGuidelineService = disposalGuidelineService;
    }


    @GetMapping()
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines(){
        List<DisposalGuideline> guidelines = disposalGuidelineService.findAllDisposalGuidelines();
        return ResponseEntity.ok(guidelines);
    }

    @GetMapping("/category/{wasteCategoryId}")
    public ResponseEntity<List<DisposalGuideline>> getDisposalGuidelinesByWasteCategory(
            @PathVariable Long wasteCategoryId) {

        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.findDisposalGuidelinesByWasteCategory(wasteCategoryId);

        return ResponseEntity.ok(disposalGuidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id){
        DisposalGuideline disposalGuideline = disposalGuidelineService.findDisposalGuidelineById(id);
        return ResponseEntity.ok(disposalGuideline);
    }

    @PostMapping("/category/{wasteCategoryId}")
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@PathVariable Long wasteCategoryId,@Valid @RequestBody DisposalGuideline disposalGuideline){
        DisposalGuideline newGuideline = disposalGuidelineService.createDisposalGuideline(wasteCategoryId,disposalGuideline);
        return ResponseEntity.created(URI.create("/disposal-guidelines/" + newGuideline.getId())).body(newGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(
            @PathVariable  Long id,@Valid @RequestBody DisposalGuideline disposalGuideline){

        DisposalGuideline updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);

        return ResponseEntity.ok(updatedDisposalGuideline);
    }

    @GetMapping("/category/{wasteCategoryId}/count")
    public ResponseEntity<Long> countDisposalGuidelinesByCategory(
            @PathVariable Long wasteCategoryId) {

        Long count = disposalGuidelineService.countDisposalGuidelinesByCategory(wasteCategoryId);

        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuidelineById(@PathVariable Long id){
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
