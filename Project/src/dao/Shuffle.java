package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Yakusyoku;

public class Shuffle {
	public List<Yakusyoku> yakusyokuShuffle(int inPlayerListSize) {
		int s = 1;
		int j = 2;
		int u = 2;

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
	        default:
	            System.out.println("エラー");
	        }



		   List<Yakusyoku> yakusyokuList = new ArrayList<Yakusyoku>();
 		   for(int i = 0; i < s ;i++) {
 			   YakusyokuDao yd = new YakusyokuDao();
 			   yakusyokuList.add(yd.getSimin());
 		   }
 		   for(int i = 0; i < j ;i++) {
			   YakusyokuDao yd = new YakusyokuDao();
			   yakusyokuList.add(yd.getJinrou());
 		   }
 		   for(int i = 0; i < u ;i++) {
			   YakusyokuDao yd = new YakusyokuDao();
			   yakusyokuList.add(yd.getUranaisi());
 		   }
 		   Collections.shuffle(yakusyokuList);

 		   return yakusyokuList;
 		   /*List<Boti> botiList = new ArrayList<Boti>();
 		   Boti boti = new Boti();
 		   for(int i = 0;i<2 ; i++) {
 			   for(Yakusyoku yakusyoku :yakusyokuList) {
 				   boti.setName(yakusyoku.getName());
 				   botiList.add(boti);
 			   }
 		   }

*/



	}

}
