package com.aug.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mobile_table")

public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imeiNo;

	@Column(name = "brand", nullable = false, length = 20)
	private String brand;

	@Column(name = "price", nullable = false, length = 7)
	private double price;

	@Column(name = "model", nullable = false, length = 20)
	private String model;

	@Column(name = "colour", nullable = false, length = 20)
	private String colour;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aId")
	Application app;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(int imeiNo, String brand, double price, String model, String colour) {
		super();
		this.imeiNo = imeiNo;
		this.brand = brand;
		this.price = price;
		this.model = model;
		this.colour = colour;
	}

	public int getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(int imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Mobile [imeiNo=" + imeiNo + ", brand=" + brand + ", price=" + price + ", model=" + model + ", colour="
				+ colour + "]";
	}

}
