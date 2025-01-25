package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions;


public class GuidelineNotFoundException extends ResourceNotFoundException {
    public GuidelineNotFoundException(Long id){
        super("Disposal Guideline",id, "DisposalGuideline with ID "+id+ " not found");
    }
}
