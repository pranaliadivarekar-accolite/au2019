package com.accolite.au.java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Q3 {

	public static void main(String[] args) throws SQLException {
		String userName = "root";
		String password = "root";
		String url = "localhost:3306";
		String databaseName = "hr";

		Statement statement = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + url + "/" + databaseName + "?useSSL=false", userName,
					password);
			statement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE,
					ResultSet.CLOSE_CURSORS_AT_COMMIT);
			rs = statement.executeQuery("SELECT * FROM books");
			
			rs.moveToInsertRow();
			rs.updateInt(1, 6);
			rs.updateString(2, "If tomorrow comes");
			rs.updateDouble(3, 350.00);
			rs.updateString(4, "Sydney Sheldon");
			rs.insertRow();

			rs.moveToInsertRow();
			rs.updateInt(1, 7);
			rs.updateString(2, "Song of Ice and Fire");
			rs.updateDouble(3, 250.00);
			rs.updateString(4, "RR Martin");
			rs.insertRow();
			
			while (rs.next()) {
				rs.updateString(2, rs.getString(2) + "(updated)");
				rs.updateRow();
			}
			
			rs = statement.executeQuery("SELECT * FROM books");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
			rs.close();
			statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}

}
