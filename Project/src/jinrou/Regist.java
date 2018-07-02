package jinrou;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Player;
import dao.PlayerDao;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String icon = request.getParameter("icon");

			PlayerDao pd = new PlayerDao();
			List<Player> playerList = pd.findAll();
			for(Player player : playerList) {
				if(player.getName().equals(name)) {
					request.setAttribute("errMsg", "なんかおかしいんだよなぁ。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}

			PlayerDao playerdao = new PlayerDao();
			playerdao.registPlayer(name, icon);
			response.sendRedirect("Index");

	}

}
