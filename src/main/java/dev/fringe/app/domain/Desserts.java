package dev.fringe.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Desserts {

	@Id
    private String name;
    private Integer calories;
    private Double fat;
    private Integer carbs;
    private Double protein;
    
	public Desserts(String name, Integer calories, Double fat, Integer carbs, Double protein) {
	    this.name = name;
	    this.calories = calories;
	    this.fat = fat;
	    this.carbs = carbs;
	    this.protein = protein;
	}
}
