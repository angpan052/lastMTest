package com.lastminute.model;

public interface ItemI {
	
	public long getQuantity();
	
	public String getType();

	public float getPrice();
	
	public void setQuantity(long quantity);
		
	public void setType(String type);

	public void setPrice(float price);

}