package com.atproject2.domain;

public class NoteBook implements Equipment{
	private String model; //machine model
	private double price; //machine price
	
	public NoteBook() {
	}
	
	public NoteBook(String model, double price) {
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		return model+"("+price+")";
	}
}
