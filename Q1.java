package com.accolite.au.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Q1 {

	PreparedStatement preparedStatement = null;
	ResultSet rs = null;

	Map<Integer, Books> insertHashMap = null;
	Map<Integer, String> updateHashMap = null;
	Map<Integer, Integer> deleteHashMap = null;

	Q1() {

	}

	public void generateHashMap() {
		insertHashMap = new HashMap<>();
		insertHashMap.put(1, new Books(1, "Angels and Demons", "Dan Brown", 100.00));
		insertHashMap.put(2, new Books(2, "Da Vinci Code", "Dan Brown", 200.00));
		insertHashMap.put(3, new Books(3, "Two states", "Chetan Bhagat", 300.00));
		insertHashMap.put(4, new Books(4, "What young India wants", "Chetan Bhagat", 400.00));
		insertHashMap.put(5, new Books(5, "Only time will tell", "Jeffery Archer", 500.00));

		updateHashMap = new HashMap<>();
		updateHashMap.put(1, "D. Brown");
		updateHashMap.put(2, "D. Brown");
		updateHashMap.put(3, "C. Bhagat");
		updateHashMap.put(4, "C. Bhagat");
		updateHashMap.put(5, "J. Archer");

		deleteHashMap = new HashMap<>();
		deleteHashMap.put(1, 100);
		deleteHashMap.put(4, 400);
		deleteHashMap.put(3, 300);

	}

	public void insertIntoBooks(Map<Integer, Books> insertHashMap, Connection con) throws SQLException {
		preparedStatement = con.prepareStatement("INSERT INTO books VALUES(?,?,?,?)");
		for(Entry<Integer, Books> map: insertHashMap.entrySet()) {
			preparedStatement.setInt(1, map.getValue().getBookId());
			preparedStatement.setString(2, map.getValue().getBookTitle());
			preparedStatement.setDouble(3, map.getValue().getBookprice());
			preparedStatement.setString(4, map.getValue().getAuthor());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		preparedStatement.close();
	}
	
	public void deleteFromBooks(Map<Integer, Integer> deleteHashMap, Connection con) throws SQLException {
		preparedStatement = con.prepareStatement("DELETE FROM books WHERE bookprice = ? AND bookId = ?");
		for(Entry<Integer, Integer> map: deleteHashMap.entrySet()) {
			preparedStatement.setInt(1, map.getValue());
			preparedStatement.setInt(2, map.getKey());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		preparedStatement.close();
	}
	
	public void updateBooks(Map<Integer, String> updateHashMap, Connection con) throws SQLException {
		preparedStatement = con.prepareStatement("UPDATE books SET author = ? where bookId = ?");
		for(Entry<Integer, String> map: updateHashMap.entrySet()) {
			preparedStatement.setInt(2, map.getKey());
			preparedStatement.setString(1, map.getValue());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		preparedStatement.close();
	}
	
	public void printTable(Connection con) throws SQLException {
		preparedStatement = con.prepareStatement("select * from books");
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}
		rs.close();
		preparedStatement.close();
	}

	public static void main(String[] args) throws SQLException {
		Q1 q1 = new Q1();
		String userName = "root";
		String password = "root";
		String url = "localhost:3306";
		String databaseName = "hr";

		Connection con = null;
		
		q1.generateHashMap();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + url + "/" + databaseName + "?useSSL=false", userName,
					password);
			q1.insertIntoBooks(q1.insertHashMap, con);
			System.out.println("Insert done!");
			System.out.println("Printing data from Books - ");
			q1.printTable(con);
			q1.updateBooks(q1.updateHashMap, con);
			System.out.println("Update done!");
			System.out.println("Printing data from Books - ");
			q1.printTable(con);
			System.out.println("Delete done!");
			System.out.println("Printing data from Books - ");
			q1.deleteFromBooks(q1.deleteHashMap, con);
			q1.printTable(con);
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}
