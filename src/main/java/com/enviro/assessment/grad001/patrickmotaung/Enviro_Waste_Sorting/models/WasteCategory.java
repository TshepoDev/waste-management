package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class WasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 100, message = "Name must be between 3 to 100 characters")
    private String name;

    @NotBlank(message = "Description cannot empty")
    @Size(min = 10, max = 250, message = "Description must be between 10 to 250 characters")
    private String description;

    public WasteCategory(){}

    public WasteCategory(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

}


