package com.lastminute.model;

public interface ItemInputI extends ItemI{
	
	public String getName();
	
	public boolean isImported();
	
	public void setName(String name);

	public void setImported(boolean imported);

}