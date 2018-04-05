package pl.coderslab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbClient {

	static private String dbName = "cl_car_crm";
	static private String dbUser = "root";
	static private String dbPass = "coderslab";

	static public int add(String query, List<String> params) throws Exception {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false",
				dbUser, dbPass)) {

			PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			for (int i = 1; i <= params.size(); i++) {
				stmt.setString(i, params.get(i - 1));
			}

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	static public void update(int id, String query, List<String> params) throws Exception {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false",
				dbUser, dbPass)) {

			PreparedStatement stmt = conn.prepareStatement(query);

			for (int i = 1; i <= params.size(); i++) {
				stmt.setString(i, params.get(i - 1));
			}

			stmt.setInt(params.size() + 1, id);
			stmt.executeUpdate();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	static public void delete(int id, String query) throws Exception {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false",
				dbUser, dbPass)) {

			PreparedStatement stmt = conn.prepareStatement(query);

			if (id != 0) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	static public List<String> selectById(int id, String query, List<String> columNames) throws Exception {

		List<String> attributesList = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false",
				dbUser, dbPass)) {

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				for (int i = 0; i < columNames.size(); i++) {
					attributesList.add(rs.getString(columNames.get(i)));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return attributesList;
	}
	

	public static List<HashMap<String, String>> selectAll(String query) throws Exception {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false",
				dbUser, dbPass)) {

			PreparedStatement st = conn.prepareStatement(query);

			st.execute();
			ResultSet rs = st.getResultSet();

			// get metadata to get columns Count
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			// list of hashmaps - each element in list is row from database,
			// with hashMap, we can
			// get easily kolumn from row by name
			List<HashMap<String, String>> result = new ArrayList<>();
			while (rs.next()) {
				// prepare HashMap for row
				HashMap<String, String> row = new HashMap<>();

				// columns in Result set are counted from 1 not from 0
				for (int i = 1; i <= columnsNumber; i++) {
					row.put(rsmd.getColumnName(i), rs.getString(i));
				}

				// Add row to List
				result.add(row);
			}
			return result;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}
