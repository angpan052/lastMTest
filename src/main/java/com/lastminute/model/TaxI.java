package com.lastminute.model;

import java.util.List;

public interface TaxI {
	
	public float getBasicSalesTax();
	
	public float getImportTax();
	
	public <T> List<T> getExceptProducts();
	
	public void setBasicSalesTax(float basicSalesTax);
	
	public void setImportTax(float importTax);

}