package lastminute.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Properties;


import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.lastminute.connection.DbConnection;

public class Helper {

	static final Logger log = Logger.getLogger(Helper.class);
	static final String CONN_PROP = "connection.properties";

	public static String loadResourceToString(final String path) {
		final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		try {
			String query = IOUtils.toString(stream);
			// log.info("QUERY: " + query);
			return query;
		} catch (final IOException e) {
			throw new IllegalStateException(e);
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}

	public static Date parseDate(String date, String format) {
		java.sql.Date sqlDate = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			java.util.Date dateUtil = sdf.parse(date);
			sqlDate = new java.sql.Date(dateUtil.getTime());
		} catch (Exception e) {
		}
		return sqlDate;
	}

	public static String getConnResource(String resource) {
		String res = null;
		Properties wsProp = new Properties();

		try {
			wsProp.load(DbConnection.class.getClassLoader().getResourceAsStream(CONN_PROP));
			res = wsProp.getProperty(resource);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Error reading connection.properties");
		}
		return res;
	}

}
