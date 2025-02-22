package com.placementmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="certificate")

public class Certificate {
	@Id
   private Integer id;
   private Integer year;
   public Certificate()
   {
	   
   }
   
public Certificate(Integer id, Integer year) {
	
	this.id = id;
	this.year = year;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}

@Override
public String toString() {
	return "certificate [id=" + id + ", year=" + year + "]";
}
   

   
}

