package com.lastminute.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.lastminute.connection.DbConnection;
import com.lastminute.dao.LastminuteDao;
import com.lastminute.exception.DAOException;
import com.lastminute.model.TaxI;
import com.lastminute.model.impl.Info;
import com.lastminute.model.impl.TaxImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import lastminute.utility.Helper;

@Repository
public class LastminuteDaoImpl implements LastminuteDao<Object> {

	static final Logger log = Logger.getLogger(LastminuteDaoImpl.class);

	@Override
	public TaxI getTaxProduct() throws DAOException {

		TaxI tax = null;
		try {
			float baseTax = Float.parseFloat(DbConnection.getBaseTax());
			float importTax = Float.parseFloat(DbConnection.getImportTax());
			tax = new TaxImpl(baseTax, importTax, DbConnection.getListExceptProduct());
		} catch (Exception e) {
			throw new DAOException("error in " + this.getClass().getName(), e);
		}
		return tax;
	}

}
