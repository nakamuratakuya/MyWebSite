package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Yakusyoku;

public class YakusyokuDao {
	public List<Yakusyoku> findAll(){
		Connection con = null;
		List<Yakusyoku> yakusyokuList = new ArrayList<Yakusyoku>();
		try {
			// データベースへ接続
			con = DBManager.getConnection();

			String sql = "SELECT * FROM yakusyoku_table";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int side = rs.getInt("side");
				String detail = rs.getString("detail");
				String comment = rs.getString("comment");
				String icon = rs.getString("icon");
				System.out.println(id+name+icon);
				Yakusyoku yakusyoku = new Yakusyoku(id, name, side, detail, comment, icon);
				yakusyokuList.add(yakusyoku);

			}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

		return yakusyokuList;
	}
}
