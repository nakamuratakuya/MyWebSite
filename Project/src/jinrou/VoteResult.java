package jinrou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Player;

/**
 * Servlet implementation class VoteResult
 */
@WebServlet("/VoteResult")
public class VoteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  session = request.getSession();
		List<Player> inPlayerList = (List<Player>) session.getAttribute("inPlayerList");
		List<Player> tousenPlayerList = new ArrayList<Player>();
		//最多票を取った人をリスト化（複数居る場合複数処刑）
		int voteCount = 0;
		for(Player player :inPlayerList) {
			if(player.getVotedCount()==voteCount) {
				tousenPlayerList.add(player);
			}
			if(player.getVotedCount()>voteCount) {
				tousenPlayerList.clear();
				tousenPlayerList.add(player);
				voteCount = player.getVotedCount();
			}
		}

		//
		if(voteCount!=1) {
			session.setAttribute("tousenPlayerList",tousenPlayerList );
			for(Player player :tousenPlayerList) {
				System.out.println(player.getName());
			}
		}

		request.getRequestDispatcher("/WEB-INF/jsp/TouhyouKekka.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
