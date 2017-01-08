package com.lastminute.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.lastminute.model.impl.Info;

public interface OrderOutputI extends OrderI {

	public float getSalesTaxes();

	public void setSalesTaxes(float salesTaxes);
	
	public <T> List<T> getInfos();

	public <T> void setInfos(List<T> infos);
	
	public float getTotal();
	
	public void setTotal(float total);
}
