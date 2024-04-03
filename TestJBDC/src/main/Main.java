package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;

public class Main {

	public static void main(String[] args) {

		// Obtendo dados SQL

		Statement st = null;
		ResultSet rs = null;

		try {
			st = Database.getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM persons");

		} catch (Exception e) {
			e.printStackTrace();

		}

		try {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("name"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				Database.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
