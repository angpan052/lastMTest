package com.lastminute.model.impl;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.OrderI;
import com.lastminute.model.OrderOutputI;

@JsonPropertyOrder({ "order" })
public class OrderOutputImpl implements OrderOutputI {

	@JsonView(Views.Public.class)
	List<ItemInputImpl> items;

	@JsonView(Views.Public.class)
	float salesTaxes;

	@JsonView(Views.Public.class)
	float total;

	@JsonView(Views.Public.class)
	List<Info> infos;

	public OrderOutputImpl() {
	}

	public OrderOutputImpl(OrderI orderI) {
		setItems(orderI.getItems());
	}

	public OrderOutputImpl(List<ItemInputImpl> items, float salesTaxes, float total, List<Info> infos) {
		super();
		this.items = items;
		this.salesTaxes = salesTaxes;
		this.total = total;
		this.infos = infos;
	}

	public List<ItemInputImpl> getItems() {
		return items;
	}

	public <T> void setItems(List<T> items) {
		this.items = (List<ItemInputImpl>) items;
	}

	public float getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(float salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public List<Info> getInfos() {
		return infos;
	}

	public <T> void setInfos(List<T> infos) {
		this.infos = (List<Info>) infos;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderInputImpl [items=" + items + ",salesTaxes=" + salesTaxes + ",total=" + total + ",infos=" + infos
				+ "]";
	}

}
