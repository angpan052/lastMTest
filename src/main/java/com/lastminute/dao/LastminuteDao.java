package com.lastminute.dao;

import com.lastminute.exception.DAOException;
import com.lastminute.model.TaxI;


public interface LastminuteDao<T> {

	public TaxI getTaxProduct() throws DAOException;
}
