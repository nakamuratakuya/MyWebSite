package jinrou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			System.out.println(name+icon);
			PlayerDao playerdao = new PlayerDao();
			boolean result = playerdao.registPlayer(name, icon);

			if(!result) {
				request.setAttribute("errMsg", "なんかおかしいんだよなぁ。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
				dispatcher.forward(request, response);

			}
			response.sendRedirect("Index");

	}

}
