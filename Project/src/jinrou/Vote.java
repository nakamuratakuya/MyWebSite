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
import dao.PlayerDao;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/Touhyou.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		PlayerDao pd = new PlayerDao();
		List<Player> inPlayerList = (List<Player>) session.getAttribute("inPlayerList");
		String playerid = request.getParameter("playerId");

		//得票数のカウント
		for(Player votedPlayer :inPlayerList) {
			if(votedPlayer.getId()==Integer.parseInt(playerid)) {
				votedPlayer.setVotedCount();
			}
		}

		//投票先を登録
		for(Player votePlayer : inPlayerList) {
			if(votePlayer.getId()==player.getId()) {
				votePlayer.setVotePlayerId(Integer.parseInt(playerid));
			}
		}

		/*Player votedPlayer = pd.selectId(playerid);*/

		session.setAttribute("inPlayerList", inPlayerList);
		response.sendRedirect("PlayerKakunin");
	}

}
