package main;

import java.sql.Connection;

import db.Database;

public class Main {

	public static void main(String[] args) {
		Database.getConnection();
		Database.closeConnection();
	}

}
