package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLDBDao implements SQLDao {
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/companydb";

	@Override
	public List<List<String>> getQueryResults(String sql) {
		List<List<String>> results = new ArrayList<List<String>>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				for (int i = 1; i < columnCount; i++) {
					row.add(rs.getString(i));
				}
				results.add(row);
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		//System.out.println(results);
		return results;
	}
	
	@Override
	public List<String> getHeaders(String sql){
		List<String> headers = new ArrayList<String>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				headers.add(rsmd.getColumnName(i));
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}
		//System.out.println(results);
		return headers;
	}






}
