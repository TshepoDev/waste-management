package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.controllers;

import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.DisposalGuideline;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models.RecyclingTip;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services.DisposalGuidelineService;
import com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.services.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/recycling-tips")
public class RecyclingTipController {
    private final RecyclingTipService recyclingTipService;


    public RecyclingTipController(RecyclingTipService recyclingTipService){
        this.recyclingTipService = recyclingTipService;
    }

    @PostMapping("/category/{wasteCategoryId}")
    public ResponseEntity<RecyclingTip> createRecyclingTip(@PathVariable Long wasteCategoryId, @Valid @RequestBody RecyclingTip recyclingTip){
        RecyclingTip newRecyclingTip = recyclingTipService.createRecyclingTip(wasteCategoryId,recyclingTip);
        return ResponseEntity.created(URI.create("/recycling-tips/" + newRecyclingTip.getId())).body(newRecyclingTip);
    }


    @GetMapping()
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips(){
        List<RecyclingTip> tips = recyclingTipService.findAllRecyclingTips();
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/category/{wasteCategoryId}")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTipsByWasteCategory(
            @PathVariable Long wasteCategoryId) {

        List<RecyclingTip> recyclingTips = recyclingTipService.findRecyclingTipsByWasteCategory(wasteCategoryId);

        return ResponseEntity.ok(recyclingTips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipsById(@PathVariable Long id){
        RecyclingTip recyclingTip = recyclingTipService.findRecyclingTipById(id);
        return ResponseEntity.ok(recyclingTip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(
            @PathVariable  Long id,@Valid @RequestBody RecyclingTip recyclingTip){

        RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);

        return ResponseEntity.ok(updatedRecyclingTip);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTipById(@PathVariable Long id){
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{wasteCategoryId}/count")
    public ResponseEntity<Long> countRecyclingTipsByCategory(
            @PathVariable Long wasteCategoryId) {

        Long count = recyclingTipService.countRecyclingTipsByCategory(wasteCategoryId);

        return ResponseEntity.ok(count);
    }
}
