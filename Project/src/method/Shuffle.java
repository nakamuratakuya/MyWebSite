package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Yakusyoku;
import dao.YakusyokuDao;



public class Shuffle {
	public List<Yakusyoku> yakusyokuShuffle(int inPlayerListSize) {

		int s = 1;
		int j = 2;
		int u = 1;
		int t = 1;

		//プレイヤーの人数に伴い追加される役職の種類とその数　
		//inPlayerListSizeは参加人数を表す。
		switch (inPlayerListSize) {
		case 3:
			break;
		case 4:
			s += 1;
			break;
		case 5:
			u += 1;
			s += 1;
			break;
		case 6:
			s += 1;
			u += 1;
			j += 1;
			break;
		case 7:
			s += 2;
			j += 1;
			u += 1;
			break;
		default:
			System.out.println("エラー");
			return null;
		}

		//データベースから役職の数を必要数取得する
		YakusyokuDao yd = new YakusyokuDao();
		List<Yakusyoku> yakusyokuList = new ArrayList<Yakusyoku>();
		for (int i = 0; i < s; i++) {
			yakusyokuList.add(yd.getSimin());
		}
		for (int i = 0; i < j; i++) {
			yakusyokuList.add(yd.getJinrou());
		}
		for (int i = 0; i < u; i++) {
			yakusyokuList.add(yd.getUranaisi());
		}
		for (int i = 0; i < t; i++) {
			yakusyokuList.add(yd.getteruteu());
		}

		Collections.shuffle(yakusyokuList);

		return yakusyokuList;
	}

}
