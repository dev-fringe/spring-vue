package dev.fringe.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Sample {
	
	@Id
    public Integer id;
    public String name;
    public Sample(int id, String name) {
    	this.id = id;
    	this.name = name;
    }

}
