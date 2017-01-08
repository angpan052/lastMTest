package com.lastminute.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.ItemI;
import com.lastminute.model.TaxI;

@JsonPropertyOrder({ "tax" })
public class TaxImpl implements TaxI {

	@JsonView(Views.Public.class)
	float basicSalesTax;

	@JsonView(Views.Public.class)
	float importTax;
	
	List<ItemInputImpl> exceptProducts;
	
	public TaxImpl(float baseTax, float importTax, String listExceptProducS) {
		this.setBasicSalesTax(baseTax);
		this.importTax = importTax;
		this.exceptProducts = new ArrayList<>();
		String[] array = listExceptProducS.split(","); 
		for (String s :array) {
			ItemInputImpl itemInputImpl = new ItemInputImpl();
			itemInputImpl.setType(s);
			this.exceptProducts.add(itemInputImpl);
		}
	}

	
	public TaxImpl(float basicSalesTax, float importTax) {
		super();
		this.basicSalesTax = basicSalesTax;
		this.importTax = importTax;
	}

	public float getBasicSalesTax() {
		return basicSalesTax;
	}

	public void setBasicSalesTax(float basicSalesTax) {
		this.basicSalesTax = basicSalesTax;
	}

	public float getImportTax() {
		return importTax;
	}

	public void setImportTax(float importTax) {
		this.importTax = importTax;
	}

	public List<ItemInputImpl> getExceptProducts() {
		return exceptProducts;
	}

	public <T> void setItems(List<T> exceptProducts) {
		this.exceptProducts = (List<ItemInputImpl>) exceptProducts;
	}

	@Override
	public String toString() {
		return "TaxImpl [basicSalesTax=" + basicSalesTax + ", importTax=" + importTax + "]";
	}

}
