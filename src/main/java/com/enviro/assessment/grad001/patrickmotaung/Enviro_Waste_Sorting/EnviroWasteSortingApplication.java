package com.enviro.assessment.grad001.patrickmotaung.Enviro_Waste_Sorting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Enviro Waste Sorting API", version = "v1", description = "API documentation for enviro waste sorting application"))
public class EnviroWasteSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviroWasteSortingApplication.class, args);
	}

}
