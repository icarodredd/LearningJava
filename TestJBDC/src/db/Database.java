package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	private static Connection con = null;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				con = DriverManager.getConnection(url, props);
				System.out.println("Database Connected!");

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
		return con;

	}

	public static void closeConnection() {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fi = new FileInputStream("db.properties")) {
			Properties prop = new Properties();
			prop.load(fi);
			return prop;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

}
