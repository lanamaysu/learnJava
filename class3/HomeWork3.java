package class3;

public class HomeWork3 {
	public static void main(String[] args) {
    Q3_1 q3_1 = new Q3_1();
    System.out.println("3-1.請使用for迴圈，練習印出以下圖案");
    q3_1.printDot(5);
    System.out.println("==============================");
    System.out.println("3-2. 請使用for迴圈與While迴圈，寫出99乘法表");
    Q3_2 q3_2 = new Q3_2();
    q3_2.usingFor();
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
class Q3_1{
  public void printDot(int maxWidth) {
    int eqaulHeight = maxWidth * 2 - 1;
    for(int i = 0; i < eqaulHeight; i++) {
      if( i < maxWidth ) {
        System.out.println('*' * (i+1));
      } else {
        System.out.println('*' * ( 2 * maxWidth - (i+1) ));
      }
    }
  }
}


/**
   3-2. 請使用for迴圈與While迴圈，寫出99乘法表
 */
class Q3_2{
  
  public void usingFor(){
    String oneLine = "";
    for(int j = 0; j < 9; j++) {
      oneLine = "";
      for(int i = 0; i < tenIntArray.length; i++) {
        int tmpInt = i+1;
        oneLine += (j+1) + "*" + tmpInt + "=" + ( (j+1) * tmpInt ) + "; ";
      }
      System.out.println(oneLine);
    }
  }
  
  public void usingWhile(){
    int i = 1;
    String oneLine = "";
		while(i < 10) {
      oneLine = "";
      while(j < 10) {
        oneLine += i + "*" + j + "=" + (i*j) + "; ";
        j++;
      }
			System.out.print(oneLine);
			i++;
		}
  }
}


/** 
  3-3. 請使用for迴圈，先用一個整數一維陣列儲存1900~2017年後，判斷那幾年是閏年? 
 */
class Q3_3 {
  public int [] years() {
    int [] yearsArray = new int[(2017-1900+1)];
    for(int i = 1900; i <= 2017; i++) {
      yearsArray[i] = i;
    }
  }
  public boolean isLeapYear(int year) {
    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
  }
  public void printLeapYear(){
    String leapYears = "";
    for(int i = 0; i < yearsArray.length; i++) {
      int thisYear = yearsArray[i];
      if(isLeapYear(thisYear)) {
        leapYears += thisYear + ", ";
      }
    }
    System.out.println(leapYears);
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
  public float avgScore(float [] scores) {
    float totalScore = 0.00;
    for(int i = 0; i < scores.length; i++) {
      totalScore += scores[i];
    }
    return totalScore/scores.length;
  }
  public void printTable() {
    System.out.println("姓名 數學 國文 英文 平均");
    System.out.println("小乖  95  80  77  " + avgScore([95, 80, 77]));
    System.out.println("小忍  55  87  89  " + avgScore([55, 87, 89]));
    System.out.println("小天  71  78  88  " + avgScore([71, 78, 88]));
  }
}


/**
 * 3-5.有一組52張撲克牌(不含鬼牌)，請幫我進行發牌動作，並且發給四個人(不重覆)。 
 */
class Q3_5 {
  
}


