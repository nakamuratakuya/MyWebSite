package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class gameResultDao {
	public	boolean registGameResult(int playerId, int yakusyokuId,int winResult) {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO syouhai_table(player_id,yakusyoku_id,winresult) VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,playerId);
			pstmt.setInt(2, yakusyokuId);
			pstmt.setInt(3, winResult);
			pstmt.executeUpdate();
			System.out.println("こんぷりーと");
			return true;
		}catch(SQLException e ){
			e.printStackTrace();
			return false;
		}finally{
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}


	}
}
