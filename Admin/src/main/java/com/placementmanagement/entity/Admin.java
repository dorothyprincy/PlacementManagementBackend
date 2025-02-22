package com.placementmanagement.entity;

import jakarta.persistence.*;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	private Integer Id;
	private String Name;
	private String Password;
	
	public Admin()
	{
		
	}
	
	
	public Admin(Integer id, String name, String password) {
		super();
		Id = id;
		Name = name;
		Password = password;
	}


	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}


	@Override
	public String toString() {
		return "Admin [Id=" + Id + ", Name=" + Name + ", Password=" + Password + "]";
	}
	
	
}