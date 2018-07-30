
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
 * Servlet implementation class Koudou
 */
@WebServlet("/Koudou")
public class Koudou extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Koudou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");

		//役職が占い師の場合専用のページに遷移
		if(player.getyName().equals("占い師")) {
			request.getRequestDispatcher("/WEB-INF/jsp/Uranaisi.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/jsp/Koudou.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("playerId");
		List<Player> inPlayerList = (List<Player>)session.getAttribute("inPlayerList");

		//エラーメッセージ
		if(id==null) {
			request.setAttribute("errMsg", "占ってください");
			request.getRequestDispatcher("/WEB-INF/jsp/Uranaisi.jsp").forward(request, response);
			return;
		}

		//占いの対象を取得
		if(id.equals("boti")) {
			String boti = "boti";
			request.setAttribute("boti", boti);
		}
		else {
			int i = Integer.parseInt(id);
			for(Player divinedPlayer : inPlayerList) {
				if(i==divinedPlayer.getId()){
					request.setAttribute("divinedPlayer", divinedPlayer);
				}
			}
		}

		request.getRequestDispatcher("/WEB-INF/jsp/UranaiKekka.jsp").forward(request, response);
	}

}
