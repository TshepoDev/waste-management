package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions;

public class TipNotFoundException extends ResourceNotFoundException {
    public TipNotFoundException(Long id) {
        super("Recycling Tip",id,"Recycling Tip with ID "+id+ " not found" );
    }
}
