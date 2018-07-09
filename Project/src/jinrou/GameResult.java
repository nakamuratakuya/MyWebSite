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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Player> inPlayerList = (List<Player>) session.getAttribute("inPlayerList");
		List<Player> tousenPlayerList = (List<Player>) session.getAttribute("tousenPlayerList");
		//勝敗判定　
		boolean  civilianWin = true;

		for (Player player : inPlayerList) {

			//プレイヤーの中に人狼がいるかつ平和村
			if(player.getyId() == 2 && tousenPlayerList == null) {
				civilianWin = false;
				break;
			}

			//プレイヤーの中に人狼がいない場合かつ処刑されるひとがいる
			else if (player.getyId() == 2 && tousenPlayerList!=null) {
				for (Player tousenPlayer : tousenPlayerList) {
					if (tousenPlayer.getyId() == 2) {
						civilianWin = true;
						break;
					}
				}
			}else {
				civilianWin = false;
				break;
			}
		}

		if(civilianWin) {
			request.setAttribute("winSide", "市民側の勝利!!!");
		}else {
			request.setAttribute("winSide", "人狼側の勝利!!!");
		}
		request.getRequestDispatcher("/WEB-INF/jsp/GameResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
