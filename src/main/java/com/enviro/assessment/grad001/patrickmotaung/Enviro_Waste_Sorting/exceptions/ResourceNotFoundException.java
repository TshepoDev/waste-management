package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.exceptions;


public abstract class ResourceNotFoundException extends RuntimeException {
    private  String resourceName;
    private Long resourceId;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }

    public String getResourceName(){
        return resourceName;
    }

    public Long getResourceId(){
        return resourceId;
    }


}
