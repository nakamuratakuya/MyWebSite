package jinrou;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Player;
import dao.PlayerDao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//登録したプレイヤーの情報を取
		PlayerDao pd = new PlayerDao();
		List<Player> playerList = pd.findAll();

		//スコープにセット
		session.setAttribute("playerList",playerList);

		//フォワード
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/Index.jsp");
		dispacher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Player> inPlayerList = new ArrayList<Player>();
		PlayerDao pd = new PlayerDao();

		String[] playerId =request.getParameterValues("playerId");

		if(playerId==null) {
			request.setAttribute("errMsg", "なんかおかしいんだよなぁ。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Index.jsp");
			dispatcher.forward(request, response);
			return;
		}

		for(String id : playerId) {
			System.out.println(id);
			Player player = pd.selectId(id);
			inPlayerList.add(player);
		}
		session.setAttribute("inPlayerList",inPlayerList);
		response.sendRedirect("inPlayer");
	}

}
