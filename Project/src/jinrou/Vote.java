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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		PlayerDao pd = new PlayerDao();
		List<Player> inPlayerList = (List<Player>) session.getAttribute("inPlayerList");
		String playerName = request.getParameter("playerName");
		//投票せれていない場合
		if(playerName==null) {
			request.setAttribute("errMsg", "投票するプレイヤーを選択してください");
			request.getRequestDispatcher("/WEB-INF/jsp/Touhyou.jsp").forward(request, response);
			return;
		}
		//得票数のカウント
		for(Player votedPlayer :inPlayerList) {
			if(votedPlayer.getName().equals(playerName)) {
				votedPlayer.setVotedCount(1);
			}
		}

		//投票先を登録
		for(Player votePlayer : inPlayerList) {
			if(votePlayer.getName().equals(player.getName())) {
				votePlayer.setVotePlayerName(playerName);
			}
		}
		Integer I = (Integer)session.getAttribute("i");
		I++;
		session.setAttribute("i", I);
		session.setAttribute("inPlayerList", inPlayerList);
		response.sendRedirect("PlayerKakunin");
	}

}
