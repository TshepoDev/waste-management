package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

public class DisposalGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min=3, max=100, message = "Name must be between 3 to 100 characters")
    private String name;

    @NotBlank(message = "Content cannot be blank")
    @Size(min=10, max=1000, message = "Content must be between 10 to 1000 characters")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waste_category_id")
    @NotNull
    private WasteCategory wasteCategory;

    public DisposalGuideline(){}

    public DisposalGuideline(String name, String content, WasteCategory wasteCategory){
        this.name = content;
        this.content = content;
        this.wasteCategory = wasteCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }


}
