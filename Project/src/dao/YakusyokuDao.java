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

	public Yakusyoku getSimin() {
		Connection con = null;
		try {

			con = DBManager.getConnection();
			String sql = "SELECT * FROM yakusyoku_table WHERE id = '1' ";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int side = rs.getInt("side");
			String detail = rs.getString("detail");
			String comment = rs.getString("comment");
			String icon = rs.getString("icon");
			Yakusyoku simin = new Yakusyoku(id, name, side, detail, comment, icon);
			return simin;
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

	}

	public Yakusyoku getJinrou() {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM yakusyoku_table WHERE id = 2 ";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int side = rs.getInt("side");
			String detail = rs.getString("detail");
			String comment = rs.getString("comment");
			String icon = rs.getString("icon");
			Yakusyoku jinrou = new Yakusyoku(id, name, side, detail, comment, icon);

			return jinrou;
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

	}
	public Yakusyoku getUranaisi() {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM yakusyoku_table WHERE id = 3 ";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int side = rs.getInt("side");
			String detail = rs.getString("detail");
			String comment = rs.getString("comment");
			String icon = rs.getString("icon");
			Yakusyoku uranaisi = new Yakusyoku(id, name, side, detail, comment, icon);

			return uranaisi;
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
	}

	public Yakusyoku getteruteu() {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM yakusyoku_table WHERE id = 4 ";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int side = rs.getInt("side");
			String detail = rs.getString("detail");
			String comment = rs.getString("comment");
			String icon = rs.getString("icon");
			Yakusyoku jinrou = new Yakusyoku(id, name, side, detail, comment, icon);

			return jinrou;
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
	}

	public Yakusyoku getYakusyoku(int randon) {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM yakusyoku_table WHERE id = ? ";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			int id = rs.getInt("id");
			String name = rs.getString("name");
			int side = rs.getInt("side");
			String detail = rs.getString("detail");
			String comment = rs.getString("comment");
			String icon = rs.getString("icon");
			Yakusyoku yakusyoku = new Yakusyoku(id, name, side, detail, comment, icon);

			return yakusyoku;
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

	}
}
