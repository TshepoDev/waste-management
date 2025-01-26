package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions;

public class CategoryNotFoundException extends ResourceNotFoundException {
    public CategoryNotFoundException(Long id) {
        super("Waste Category",id,"Waste Category with ID "+ id + " not found");
    }
}
