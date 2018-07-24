package jinrou;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Player;
import dao.gameResultDao;

/**
 * Servlet implementation class GameResult
 */
@WebServlet("/GameResult")
public class GameResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Player> inPlayerList = (List<Player>) session.getAttribute("inPlayerList");
		List<Player> tousenPlayerList = (List<Player>) session.getAttribute("tousenPlayerList");
		//勝敗判定　

		//市民勝利ならtrue
		boolean civilianWin = false;

		//吊るされる人がいる場合true
		boolean executeFrg = false;

		//プレイヤーの中に人狼ｈがいる場合true
		boolean jinrouExistence = false;

		//playerに人狼がいるかの確認
		for(Player player : inPlayerList) {
			if(player.getyId()==2) {
				jinrouExistence = true;
			}
		}

		//吊るされた人がいるかの確認
		if(tousenPlayerList!=null){
			executeFrg = true;
		}

		//吊るされる人がいるかつプレイヤーに人狼がいる
		if(executeFrg  && jinrouExistence){
			for(Player tousenPlayer : tousenPlayerList){
				if(tousenPlayer.getyId()==2){
					civilianWin = true;
				}
			}
		}
		
		else if(!executeFrg && !jinrouExistence){
			civilianWin = true;
		}

		if (civilianWin) {
			request.setAttribute("winSide", "市民側の勝利!!!");
		} else {
			request.setAttribute("winSide", "人狼側の勝利!!!");
		}


		//リザルトの登録

		//登録の準備
		gameResultDao grd = new gameResultDao();

		//勝った場合１負けたら０
		int winResult;

		//登録
		for(Player player :inPlayerList) {
			if(civilianWin && player.getyId()!=2) {
				winResult = 1;
			}else if(!civilianWin && player.getyId()==2) {
				winResult = 1;
			}else {
				winResult = 0;
			}
			grd.registGameResult(player.getId(), player.getyId(), winResult);
		}

		request.getRequestDispatcher("/WEB-INF/jsp/GameResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
