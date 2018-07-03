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
 * Servlet implementation class PlayerKekka
 */
@WebServlet("/PlayerKekka")
public class PlayerKekka extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerKekka() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*Player player = (Player)session.getAttribute("palyer");*/
		List<Player> inPlayerList = (List<Player>)session.getAttribute("inPlayerList");
		List<Player> jinrouList = new ArrayList<Player>();
		for(Player player : inPlayerList) {
			if(player.getyName().equals("人狼")) {
				jinrouList.add(player);
				request.setAttribute("jinrouList", jinrouList);
			}
		}
		request.getRequestDispatcher("/WEB-INF/jsp/PlayerKekka.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
