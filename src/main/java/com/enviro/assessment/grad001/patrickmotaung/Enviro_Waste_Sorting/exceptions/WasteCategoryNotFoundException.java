package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions;

public class WasteCategoryNotFoundException extends ResourceNotFoundException {
    public WasteCategoryNotFoundException(Long id) {
        super("Waste Category",id,"Waste Category with ID "+ id + " not found");
    }
}
