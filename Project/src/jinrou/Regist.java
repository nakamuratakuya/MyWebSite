package jinrou;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Player;
import dao.PlayerDao;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

			Part part = request.getPart("icon");
			if(part.getSize()==0) {
		    	request.setAttribute("errMsg","画像を登録してください");
		      	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
		      	dispatcher.forward(request, response);
				return;
		    }
			String filename = part.getSubmittedFileName();
		/*	if(filename==null) {
		    	request.setAttribute("errMsg","画像を登録してください");
		      	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
		      	dispatcher.forward(request, response);
				return;
		    }*/
	       /* String iconName = this.getFileName(part);*/
	        part.write(getServletContext().getRealPath("/img") + "/" + filename);



			PlayerDao pd = new PlayerDao();
			List<Player> playerList = pd.findAll();
			for(Player player : playerList) {
				if(player.getName().equals(name)) {
					request.setAttribute("errMsg", "その名前は既に使われています");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}

			PlayerDao playerdao = new PlayerDao();
			playerdao.registPlayer(name, filename);
			response.sendRedirect("Index");

	}


}
