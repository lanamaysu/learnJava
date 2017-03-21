package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Practice {
  public static void main(String[] args) {
    // new Mi_1().printDot(9);
    new Mi_3().scoreEngine();
  }
}


/**
 * <pre>
 * 請使用for迴圈，練習印出以下圖案
 *  *       *
 *   *     *
 *    *   *
 *     * *
 *      *
 *     * *
 *    *   *
 *   *     *
 *  *       *
 * </pre>
 */
class Mi_1 {
  public void printDot(int hiehgt) {
    for (int i = 0; i < hiehgt; i++) {
      oneline(i, hiehgt);
    }
  }

  public void oneline(int i, int hiehgt) {
    char[] thisLine = new char[hiehgt];
    thisLine[i] = '*';
    thisLine[hiehgt - 1 - i] = '*';
    System.out.println(new String(thisLine).replace("\0", " "));
  }
}


/**
 * <pre>
 * 1. 首先產生一組陣列，裡面擺放正整數 0~5
 * 2. 產生一個目標答案，亂數答案是 1~9 之間
 * 3. 利用第一組陣列，隨機兩個元素相加，會等於目標答案，並印出兩個陣列位置
 * </pre>
 */
class Mi_2 {
  public void calc() {

  }

  public int[] intPool(int maxInt) {
    int[] pool = new int[maxInt];
    for (int i = 0; i <= maxInt; i++) {
      pool[i] = i;
    }
    return pool;
  }

  public int randomAns(int min, int max) {
    return min + new Random().nextInt(max + 1);
  }
}


/**
 * <pre>
 * 學生資料
 * 學號  姓名
 * S1    小天
 * S2    小忍
 * S3    小玉
 * 
 * 成績資料
 * 學號  數學  英文  國文
 * S1     80   100    87
 * S2     99    94    78
 * S3     55    79    77
 * 
 * 請用新增學生與成績類別(Class)
 * 設定每位學生資料以及設定各科成績資料後
 * 
 * 1.用學號查詢學生各科的成績
 * 2.每位學生的平均成績
 * 3.各科的平均成績
 * 4.每科最高分數
 * 5.每科最低分數
 * </pre>
 */
class Mi_3 {
  final HashMap<String, ScoreData> SCOREBOARD = genScoreboard();
  final List<List<Integer>> SUBJECTDATA = getSubjectDataArr();

  public void scoreEngine() {
    System.out.println("=== 開始查詢 ===");
    Scanner sc = new Scanner(System.in);
    boolean outterFlag = true;
    int chooseItem = 1;
    while (outterFlag) {
      chooseItem = chooseSearchFunction(sc);
      switch (chooseItem) {
        case 1:
          printStudenScore(sc);
          break;
        case 2:
          printSubjectAvg(SUBJECTDATA);
          break;
        case 3:
          printMinMax();
          break;
        default:
          System.out.println("查無資料");
      }
      System.out.print("回到選擇查詢項目(Y)或退出(N):");
      outterFlag = checkContinue(sc);
    }
    sc.close();
    System.out.println("=== 結束查詢 ===");
  }

  public ScoreData newScore(int math, int english, int chinese, String name, String id) {
    ScoreData thisScore = new ScoreData();
    thisScore.setMath(math);
    thisScore.setEnglish(english);
    thisScore.setChinese(chinese);
    thisScore.setName(name);
    thisScore.setId(id);
    return thisScore;
  }

  public HashMap<String, ScoreData> genScoreboard() {
    HashMap<String, ScoreData> Scoreboard = new HashMap<String, ScoreData>();
    Scoreboard.put("S1", newScore(80, 100, 87, "小天", "S1"));
    Scoreboard.put("S2", newScore(99, 94, 78, "小忍", "S2"));
    Scoreboard.put("S3", newScore(55, 79, 77, "小玉", "S3"));
    return Scoreboard;
  }
  
  public void printStudenScore(Scanner sc) {
    boolean flag = true;
    while (flag) {
      ScoreData data = getScoreFromID(sc);
      printSubjectScore(data);
      System.out.print("繼續查詢學生各科成績與平均? (Y/N) ");
      flag = checkContinue(sc);
    }
  }

  public ScoreData getScoreFromID(Scanner sc) {
    String id = "";
    ScoreData thisScore = null;
    boolean getResult = false;
    while (!getResult) {
      System.out.print("輸入學號: ");
      id = sc.next();
      thisScore = SCOREBOARD.get(id);
      getResult = thisScore != null;
      if (!getResult) {
        System.out.printf("學號不存在!%n");
      }
    }
    return thisScore;
  }

  public void printSubjectScore(ScoreData data) {
    int[] score = {data.getMath(), data.getEnglish(), data.getChinese()};
    System.out.printf("%s - %s%n", data.getName(), data.getId());
    System.out.printf("數學: %3d | ", score[0]);
    System.out.printf("英文: %3d | ", score[1]);
    System.out.printf("國文: %3d | ", score[2]);
    System.out.printf("平均: %5.2f%n", calcAvgScore(score));
  }

  public List<List<Integer>> getSubjectDataArr() {
    int length = SCOREBOARD.size();
    List<Integer> arrMath = new ArrayList<Integer>(length);
    List<Integer> arrChinese = new ArrayList<Integer>(length);
    List<Integer> arrEnglish = new ArrayList<Integer>(length);
    for (String key : SCOREBOARD.keySet()) {
      int math = SCOREBOARD.get(key).getMath();
      int eng = SCOREBOARD.get(key).getEnglish();
      int cn = SCOREBOARD.get(key).getChinese();
      arrMath.add(math);
      arrEnglish.add(eng);
      arrChinese.add(cn);
    }
    List<List<Integer>> all = new ArrayList<List<Integer>>(3);
    all.add(arrMath);
    all.add(arrEnglish);
    all.add(arrChinese);
    return all;
  }

  public void printSubjectAvg(List<List<Integer>> dataArr) {
    List<Long> sumArr = new ArrayList<Long>();
    List<Integer> amtArr = new ArrayList<Integer>();
    for (int i = 0; i < dataArr.size(); i++) {
      long sum = 0;
      int scoreAmt = 0;
      for (Integer score : dataArr.get(i)) {
        sum += score;
        scoreAmt++;
      }
      sumArr.add(sum);
      amtArr.add(scoreAmt);
    }
    System.out.printf("各科平均:%n數學 %5.2f | 英文 %5.2f | 國文 %5.2f%n",
        (float) sumArr.get(0) / amtArr.get(0), (float) sumArr.get(1) / amtArr.get(1),
        (float) sumArr.get(2) / amtArr.get(2));
  }

  public int[] getMinMaxScore(List<Integer> scoreArr) {
    int[] minmax = new int[2];
    minmax[0] = Collections.min(scoreArr);
    minmax[1] = Collections.max(scoreArr);
    return minmax;
  }

  public void printMinMax() {
    int[] mathMinMax = getMinMaxScore(SUBJECTDATA.get(0));
    int[] engthMinMax = getMinMaxScore(SUBJECTDATA.get(1));
    int[] chMinMax = getMinMaxScore(SUBJECTDATA.get(2));
    System.out.printf("各科最高: 數學 %3d | 英文 %3d | 國文 %3d%n", mathMinMax[1], engthMinMax[1],
        chMinMax[1]);
    System.out.printf("各科最低: 數學 %3d | 英文 %3d | 國文 %3d%n", mathMinMax[0], engthMinMax[0],
        chMinMax[0]);
  }

  public float calcAvgScore(int[] scoreArr) {
    int arrLength = scoreArr.length;
    int sum = 0;
    for (int i = 0; i < arrLength; i++) {
      sum += scoreArr[i];
    }
    return (float) sum / arrLength;
  }

  public int chooseSearchFunction(Scanner sc) {
    System.out.printf("1.學號查詢學生各科成績與平均%n2.各科平均成績%n3.每科最高與最低分數%n");
    System.out.print("選擇查詢項目: ");
    boolean inputValidate = false;
    int input = 1;
    while (!inputValidate) {
      try {
        input = sc.nextInt();
        if (input >= 1 && input <= 3) {
          inputValidate = true;
        } else {
          System.out.print("無此項目，請輸入1-3的數字: ");
          sc.nextLine();
        }
      } catch (InputMismatchException e) {
        System.out.print("無此項目，請輸入1-3的數字: ");
        sc.nextLine();
      }
    }
    return input;
  }

  public boolean checkContinue(Scanner sc) {
    String wantContinue = sc.next();
    boolean flag = false;
    switch (wantContinue) {
      case "Y":
      case "y":
        flag = true;
        break;
      case "N":
      case "n":
      default:
        flag = false;
        break;
    }
    return flag;
  }

}


class ScoreData {
  private String id;
  private String name;
  private int math;
  private int english;
  private int chinese;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getEnglish() {
    return english;
  }

  public void setEnglish(int english) {
    this.english = english;
  }

  public int getChinese() {
    return chinese;
  }

  public void setChinese(int chinese) {
    this.chinese = chinese;
  }

}
