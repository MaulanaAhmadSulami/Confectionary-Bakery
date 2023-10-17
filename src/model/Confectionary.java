package model;

import java.util.ArrayList;

import adapter.PriceAdapter;


public class Confectionary {

	String type, name, softness;
	PriceAdapter price;
	String paymentType;
	
	ArrayList<String> toppings = new ArrayList<String>();

	public Confectionary(String type, String name, String softness, PriceAdapter price, String paymentType,
			ArrayList<String> toppings) {
		super();
		this.type =	 type;
		this.name = name;
		this.softness = softness;
		this.price = price;
		this.paymentType = paymentType;
		this.toppings = toppings;
	}

	public Confectionary() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSoftness() {
		return softness;
	}

	public void setSoftness(String softness) {
		this.softness = softness;
	}

	public PriceAdapter getPrice() {
		return price;
	}

	public void setPrice(PriceAdapter price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}

	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}


	

	

}