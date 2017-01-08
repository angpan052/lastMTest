package com.lastminute.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.mongodb.MongoClient;

@SuppressWarnings("deprecation")
public class DbConnection {

	static final Logger log = Logger.getLogger(DbConnection.class);
	
	private static String baseTax;
	private static String importTax;
	private static String listExceptProduct = null;

	public static String getListExceptProduct() {
		return listExceptProduct;
	}

	public static void setListExceptProduct(String listExceptProduct) {
		DbConnection.listExceptProduct = listExceptProduct;
	}

	public static String getBaseTax() {
		return baseTax;
	}

	public static void setBaseTax(String baseTax) {
		DbConnection.baseTax = baseTax;
	}

	public static String getImportTax() {
		return importTax;
	}

	public static void setImportTax(String importTax) {
		DbConnection.importTax = importTax;
	}

	static {
		Properties wsProp = new Properties();

		try {
			wsProp.load(DbConnection.class.getClassLoader().getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		listExceptProduct = wsProp.getProperty("LastMinute.baseTax.exceptProducts");
		baseTax = wsProp.getProperty("LastMinute.baseTax");
		importTax = wsProp.getProperty("LastMinute.importTax");

	}

}
