package com.accolite.au.java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q2 {

	public static void main(String[] args) throws SQLException {
		String userName = "root";
		String password = "root";
		String url = "localhost:3306";
		String databaseName = "hr";
		ResultSet rs = null;

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + url + "/" + databaseName + "?useSSL=false", userName,
					password);
			DatabaseMetaData databaseMetaData = con.getMetaData();

			System.out.println("---Tables----");
			String table[] = { "TABLE" };
			rs = databaseMetaData.getTables(null, null, null, table);
			ResultSet rsPK = null;
			ResultSet rsColumn = null;

			while (rs.next()) {
				System.out.println(rs.getString(3));
				 rsColumn = databaseMetaData.getColumns(null, null, rs.getString(3), null);
				while (rsColumn.next()) {
					String columnName = rsColumn.getString("COLUMN_NAME");
					String columnType = rsColumn.getString("TYPE_NAME");
					int columnSize = rsColumn.getInt("COLUMN_SIZE");
					System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")");
				}
				rsPK = databaseMetaData.getPrimaryKeys(null, null, rs.getString(3));
				while (rsPK.next()) {
					String primaryKeyColumn = rsPK.getString("COLUMN_NAME");
					System.out.println("\tPrimary Key Column: " + primaryKeyColumn);
				}
			}

			System.out.println("---Views----");
			String views[] = { "VIEWS" };
			rs = databaseMetaData.getTables(null, null, null, views);
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}

			rsPK.close();
			rsColumn.close();
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

}