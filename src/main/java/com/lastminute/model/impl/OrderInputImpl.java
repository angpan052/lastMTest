package com.lastminute.model.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.OrderI;

@JsonPropertyOrder({ "order" })
public class OrderInputImpl implements OrderI {

	@JsonView(Views.Public.class)
	List<ItemInputImpl> items;
	
	public OrderInputImpl() {
	}
	
	public OrderInputImpl(List<ItemInputImpl> items) {
		super();
		this.items = items;
	}

	public List<ItemInputImpl> getItems() {
		return items;
	}

	public <T> void setItems(List<T> items) {
		this.items = (List<ItemInputImpl>)items;
	}

	@Override
	public String toString() {
		return "OrderInputImpl [items=" + items + "]";
	}	

}
