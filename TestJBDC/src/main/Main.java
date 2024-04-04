package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Database;

public class Main {

	public static void main(String[] args) {

		// Obtendo dados SQL
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			con = Database.getConnection();
			st = con.createStatement();
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
			Database.closeStatementAndSet(st, rs);

		}

		// Inserindo dados

		PreparedStatement ps = null;
		try {
			con = Database.getConnection();
			ps = con.prepareStatement("INSERT INTO persons " + "(id, name) " + "VALUES (?, ?)");
			ps.setInt(1, 3);
			ps.setString(2, "icaro");
			// Alterar os dados
			// Retornando linhas afetadas

			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeConnection();

		}

		// confirmando as changes na database
		// con.setAutoCommit(false);
		// con.commit();

		// voltando as alteraçoes
		// con.rollback();

	}

}
