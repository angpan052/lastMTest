package com.lastminute.model.impl;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.ItemI;
import com.lastminute.model.ItemInputI;
import com.lastminute.model.ItemOutputI;

@JsonPropertyOrder({ "item" })
public class ItemOutputImpl implements ItemOutputI {

	@JsonView(Views.Public.class)
	long quantity;
	
	@JsonView(Views.Public.class)
	String type;

	@JsonView(Views.Public.class)
	float price;

	@JsonView(Views.Public.class)
	float salesTaxes;

	public ItemOutputImpl() {
	}

	public ItemOutputImpl(long quantity, String type, float price, float salesTaxes) {
		super();
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.salesTaxes = salesTaxes;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(float salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	@Override
	public String toString() {
		return "ItemInputImpl [quantity=" + quantity + ",type=" + type + ",price=" + price + ",salesTaxes=" + salesTaxes + "]";
	}

}
