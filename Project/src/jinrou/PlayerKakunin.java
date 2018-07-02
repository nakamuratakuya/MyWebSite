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
 * Servlet implementation class PlayerKakunin
 */
@WebServlet("/PlayerKakunin")
public class PlayerKakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerKakunin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Player> inPlayerList = (List<Player>)session.getAttribute("inPlayerList");
		Integer I =(Integer)session.getAttribute("i");
		int i = I.intValue();
		if(i==inPlayerList.size()) {
			request.getRequestDispatcher("/WEB-INF/jsp/Hanasiai.jsp").forward(request, response);
			return;
		}
		Player player = inPlayerList.get(i);
		I+=1;
		session.setAttribute("player", player);
		session.setAttribute("i", I);
		if(player.getyName().equals("占い師")) {
			request.getRequestDispatcher("/WEB-INF/Jsp/Uranai.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/PlayerKakunin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
