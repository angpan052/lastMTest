package com.lastminute.model.impl;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.ItemI;

@JsonPropertyOrder({ "item" })
public class ItemInputImpl implements ItemI {

	@JsonView(Views.Public.class)
	long quantity;
	
	@JsonView(Views.Public.class)
	String name;

	@JsonView(Views.Public.class)
	String type;

	@JsonView(Views.Public.class)
	float price;

	@JsonView(Views.Public.class)
	boolean imported;

	@JsonView(Views.Public.class)
	TaxImpl tax;

	public ItemInputImpl() {
	}

	public ItemInputImpl(long quantity, String name, String type, float price, boolean imported, TaxImpl tax) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.type = type;
		this.price = price;
		this.imported = imported;
		this.tax = tax;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public TaxImpl getTax() {
		return tax;
	}

	public void setTax(TaxImpl tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "ItemInputImpl [quantity=" + quantity + ",name=" + name + ",type=" + type + ",price=" + price + ", imported=" + imported + ", tax=" + tax + "]";
	}

}
