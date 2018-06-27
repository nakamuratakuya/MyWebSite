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

import beans.Yakusyoku;
import dao.YakusyokuDao;

/**
 * Servlet implementation class inPlayer
 */
@WebServlet("/inPlayer")
public class inPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public inPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		List<Yakusyoku> yakusyokuList = new ArrayList<Yakusyoku>();
		YakusyokuDao yd = new YakusyokuDao();
		yakusyokuList = yd.findAll();

		session.setAttribute("yakusyokuList", yakusyokuList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inPlayer.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
