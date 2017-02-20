package class3;

public class HomeWork3 {
  public static void main(String[] args) {
    Q3_1 q3_1 = new Q3_1();
    System.out.println("3-1.請使用for迴圈，練習印出以下圖案");
    q3_1.printDot(5);
    System.out.println("==============================");
    System.out.println("3-2. 請使用for迴圈與While迴圈，寫出99乘法表");
    Q3_2 q3_2 = new Q3_2();
    System.out.println("for loop:");
    q3_2.usingFor();
    System.out.println("while loop:");
    q3_2.usingWhile();
    System.out.println("==============================");
    System.out.println("3-3. 請使用for迴圈，先用一個整數一維陣列儲存1900~2017年後，判斷那幾年是閏年?");
    Q3_3 q3_3 = new Q3_3();
    q3_3.printLeapYear();
    System.out.println("==============================");
    System.out.println("3-4. 有三個學生，期末考結束了，公佈了三科成績，請幫我算一下各科平均分數，每個人平均分數，需要精確到小數點兩位。");
    Q3_4 q3_4 = new Q3_4();
    q3_4.printTable();
  }
}


/**
  <pre>
    3-1.請使用for迴圈，練習印出以下圖案
    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
  </pre>
*/
class Q3_1 {
  public void printDot(int maxWidth) {
    int eqaulHeight = maxWidth * 2 - 1;
    for (int i = 0; i < eqaulHeight; i++) {
      if (i < maxWidth) {
        System.out.println(new String(new char[i+1]).replace("\0", "*"));
      } else {
        System.out.println(new String(new char[(2 * maxWidth) - (i + 1)]).replace("\0", "*"));
      }
    }
  }
}


/**
   3-2. 請使用for迴圈與While迴圈，寫出99乘法表
 */
class Q3_2 {

  public void usingFor() {
    String oneLine = "";
    for (int j = 0; j < 9; j++) {
      oneLine = "";
      for (int i = 0; i < 9; i++) {
        int tmpInt = i + 1;
    	String result = Integer.toString((j + 1) * tmpInt);
    	if(result.length() < 2) {
    	  result = " " + result;
    	}
        oneLine += (j + 1) + "*" + tmpInt + "=" + result + "; ";
      }
      System.out.println(oneLine);
    }
  }

  public void usingWhile() {
    int i = 1;
    String oneLine = "";
    while (i < 10) {
      int j = 1;
      while (j < 10) {
    	String result = Integer.toString(i * j);
    	if(result.length() < 2) {
    	  result = " " + result;
    	}
        oneLine += i + "*" + j + "=" + result + "; ";
        j++;
      }
      oneLine += "\n";
      i++;
    }
    System.out.print(oneLine);
  }
}


/** 
  3-3. 請使用for迴圈，先用一個整數一維陣列儲存1900~2017年後，判斷那幾年是閏年? 
 */
class Q3_3 {
  public int [] years() {
    int [] yearsArray = new int[(2017 - 1900)];
    for (int i = 1900; i < 2017; i++) {
      yearsArray[i - 1900] = i;
    }
    return yearsArray;
  }
  public boolean isLeapYear(int year) {
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
  }
  public void printLeapYear() {
    int [] yearsArray = years();
    for (int i = 0; i < yearsArray.length; i++) {
      int thisYear = yearsArray[i];
      if (isLeapYear(thisYear)) {
    	System.out.println(thisYear);
      }
    }
  }
}


/**
 * <pre>
 * 有三個學生，期末考結束了，公佈了三科成績，請幫我算一下各科平均分數，每個人平均分數，需要精確到小數點兩位。
 *
 *  姓名  數學    國文   英文
 *  小乖   95    80   77
 *  小忍   55    87   89
 *  小天   71    78   88
 * </pre>
 */
class Q3_4 {
  public float avgScore(float score1, float score2, float score3) {
	float totalScore = score1 + score2 + score3;
    return totalScore / 3;
  }
  public void printTable() {
    System.out.println("姓名 數學 國文 英文 平均");
    System.out.printf("小乖  95  80  77  %.2f \n", avgScore(95, 80, 77));
    System.out.printf("小忍  55  87  89  %.2f \n", avgScore(55, 87, 89));
    System.out.printf("小天  71  78  88  %.2f \n", avgScore(71, 78, 88));
    System.out.printf("數學平均           %.2f \n", avgScore(95, 55, 71));
    System.out.printf("國文平均           %.2f \n", avgScore(80, 87, 78));
    System.out.printf("英文平均           %.2f \n", avgScore(77, 89, 88));
  }
}


/**
 * 3-5.有一組52張撲克牌(不含鬼牌)，請幫我進行發牌動作，並且發給四個人(不重覆)。 
 */
class Q3_5 {

}