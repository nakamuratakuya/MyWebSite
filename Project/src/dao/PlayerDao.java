package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Player;

public class PlayerDao {

	public List<Player> findAll(){
		Connection con =null;
		List<Player> playerList = new ArrayList<Player>();
		try {
			// データベースへ接続
			con = DBManager.getConnection();

			String sql = "SELECT * FROM player_table";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String icon = rs.getString("icon");
				Player player = new Player(id,name,icon);
				playerList.add(player);

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

		return playerList;
	}

	public boolean registPlayer(String name, String icon) {
		Connection con = null;

		try {
			// データベースへ接続
			con = DBManager.getConnection();
			// SELECT文を準備
			String sql ="INSERT INTO player_table(name,icon) VALUES(?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,icon);
			pstmt.executeUpdate();
			return true;

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			//データベース切断
			if(con !=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public Player selectId(String Id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "select t1.id, t1.name, t1.icon, "
						+"count(t2.player_id) as game_count,"
						+" ifnull(sum(t2.winresult),0) as win_count"
						+" from player_table as t1 "
						+"left outer join syouhai_table as t2 on t1.id  = t2.player_id "
						+"where t1.id = ? "
						+"group by t1.id "
						+"order by t1.id";



			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Id);
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String icon = rs.getString("icon");
			Player player = new Player(id,name,icon);
			player.setGamecount(rs.getInt("game_count"));
			player.setWincount(rs.getInt("win_count"));
			return player;
		}

		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}


	public void  playerDelete(String id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "DELETE FROM player_table WHERE id =?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);

			pStmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
}