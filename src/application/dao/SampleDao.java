package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Sample;

public class SampleDao {

	public List<Sample> find(String id) {
		List<Sample> lst = new ArrayList<>();
		Connection con = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			con = DriverManager.getConnection("jdbc:sqlite:C:/sample.db");
			String sql = "select * from sample ";
			if (id != null && !id.equals("")) {
				sql = sql.concat("where id = ?");
			}
			statement = con.prepareStatement(sql);
			if (id != null && !id.equals("")) {
				statement.setString(1, id);
			}

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Sample sample = new Sample();
				sample.setId(rs.getString("id"));
				sample.setPass(rs.getString("pass"));
				sample.setName(rs.getString("name"));
				lst.add(sample);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
}
