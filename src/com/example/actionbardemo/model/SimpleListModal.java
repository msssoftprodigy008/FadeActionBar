package com.example.actionbardemo.model;

public class SimpleListModal {

	private String name;
	private String description;
	
	public SimpleListModal(String nam, String desc)
	{
		this.name = nam;
		this.description = desc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
