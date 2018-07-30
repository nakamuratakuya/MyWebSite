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

import beans.Boti;
import beans.Player;
import beans.Yakusyoku;
import dao.YakusyokuDao;
import method.Shuffle;

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
		//参加者の取得
		List<Player> inPlayerList = (List<Player>)session.getAttribute("inPlayerList");

		//sessionのremove
		session.removeAttribute("voteFrg");
		session.removeAttribute("tousenPlayerList");
		session.removeAttribute("yakusyokuList");
		session.removeAttribute("siminCuont");
		session.removeAttribute("jinrouCount");
		session.removeAttribute("uranaisiCount");

		//得票数やらのリセット
		for(Player player : inPlayerList) {
			player.setVotePlayerName(null);
			player.setVotedCount(0);
		}

		List<Yakusyoku> yakusyokuList = new ArrayList<Yakusyoku>();
		YakusyokuDao yd = new YakusyokuDao();
		yakusyokuList = yd.findAll();

		//必要数の役職をリスト化しシャッフル
		Shuffle shuffle = new Shuffle();
		List<Yakusyoku> ShuffledYakusyokuList = new ArrayList<Yakusyoku>();
		ShuffledYakusyokuList =  shuffle.yakusyokuShuffle(inPlayerList.size());

		//役職のカウント
		Integer siminCount=0;
		Integer jinrouCount=0;
		Integer uranaisiCount=0;
		for(Yakusyoku yakusyoku :ShuffledYakusyokuList) {
			if(yakusyoku.getName().equals("市民")) {
				siminCount++;
			}else if(yakusyoku.getName().equals("人狼")) {
				jinrouCount++;
			}else if(yakusyoku.getName().equals("占い師")) {
				uranaisiCount++;
			}
		}

		//役職の振分け
		for(Player player :inPlayerList) {
			player.setyId(ShuffledYakusyokuList.get(0).getId());
			player.setyName(ShuffledYakusyokuList.get(0).getName());
			player.setyDetail(ShuffledYakusyokuList.get(0).getDetail());
			player.setyComment(ShuffledYakusyokuList.get(0).getComment());
			player.setyIcon(ShuffledYakusyokuList.get(0).getIcon());
			ShuffledYakusyokuList.remove(0);
			System.out.println(player.getyName()+"player");
		}

		//墓地を用意
		List<Boti> botiList = new ArrayList<Boti>();
		
		for(Yakusyoku yakusyoku :ShuffledYakusyokuList) {
		   Boti boti = new Boti();
		   boti.setName(yakusyoku.getName());
		   boti.setIcon(yakusyoku.getIcon());
		   botiList.add(boti);
			System.out.println(boti.getName()+"boti");
		}

		session.setAttribute("botiList", botiList);
		session.setAttribute("inPlayerList", inPlayerList);
		session.setAttribute("yakusyokuList", yakusyokuList);
		session.setAttribute("siminCount", siminCount);
		session.setAttribute("jinrouCount", jinrouCount);
		session.setAttribute("uranaisiCount", uranaisiCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/inPlayer.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*List<Player> inPlayerList = (List<Player>)session.getAttribute("inPlayerList");*/
		Integer i = 0;
		session.setAttribute("i", i);
		response.sendRedirect("PlayerKakunin");
	}

}
