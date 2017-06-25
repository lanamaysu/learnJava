package class8;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

public class Homework8{
  public static void main(String[] args) {
//    new Q8_1().ans();
    new Q8_2().ans();
  }
}


/**
 * <pre>
 *  使用try catch
 *  捕捉1/0的錯誤，要顯示不可除以0
 *  捕捉類似1/3的錯誤，提示會無限循環小數，並只格式化到小數點第三位
 * </pre>
 */
class Q8_1{
  public void ans() {
    System.out.println("Caculate 1/0 :" + fractionsTryCatchInt(1, 0));
    System.out.println("Caculate 1/3 :" + fractionsTryCatchDouble(1, 3));
  }
  public String fractionsTryCatchInt(int numerator, int denominator) {
    String fractions = null;
    NumberFormat formatter = new DecimalFormat("#0.000");
    try {
      fractions = formatter.format(numerator/denominator);
    } catch (Exception e) {
      e.printStackTrace();
      if(denominator == 0) {
        System.out.println("分母不可為0");
      }
    }
    if(fractions != null) {
      return fractions;
    } else {
      return "無法計算";
    }
  }
  public String fractionsTryCatchDouble(double d, double f) {
    String fractions = null;
    NumberFormat formatter = new DecimalFormat("#0.000");
    try {
      fractions = formatter.format(d/f);
    } catch (Exception e) {
      e.printStackTrace();
      if(f == 0) {
        System.out.println("分母不可為0");
      }
    }
    if(fractions != null) {
      return fractions;
    } else {
      return "無法計算";
    }
  }
}

/**
 * <pre>
 *  我們要進行動物賽跑比賽
 *  目前有三個參賽者
 *  烏龜，兔子，小豬
 *  烏龜每一秒前進一公尺，每次休息0.35~0.55秒
 *  小豬每一秒前進兩公尺，每次休息0.35~3.5秒
 *  兔子每一秒前進三公尺，每次休息2.6~4秒
 *  賽道長度是100M
 *  每次比賽都是同時出發
 *  請問10000次比賽下來，誰是常勝軍
 *  
 *  Hit : 用Random產生隨機數字 1000~1500，產生出來後，
 *        就會在秒數就會在1秒~1.5秒之間，以此類推
 *        Thread.Sleep(1500)，單位是千毫秒
 * </pre>
 */
class Q8_2{
  int raceDistance = 100;
  List<player> participants = new ArrayList<player>();
  Map<String, List<Double>> leaderboards = new HashMap<String, List<Double>>();
  
  public void ans() {
    doMultipleRace(100);
  }
  
  public void doMultipleRace(int count) {
    for (int i = 0; i < count; i++) {
      doRace();
    }
    Entry<String, List<Double>> finalWinner = null;
    for (Entry<String, List<Double>> entry : leaderboards.entrySet()) {
      if (finalWinner == null || finalWinner.getValue().size() > entry.getValue().size()) {
        finalWinner = entry;
      }
      System.out.println(entry.getKey() + ":" + entry.getValue().toString());
    }
    System.out.println("Final Winner: " + finalWinner.getKey());
    System.out.println("Final Winner Personal Best: " + Collections.min(finalWinner.getValue()));
  }
  
  public void doRace() {
    Map<String, Double> onceLeaderBoard = new HashMap<String, Double>();
    initPlayers();
    for (player player : participants) {
      onceLeaderBoard.put(player.getName(), countRaceTime(player));
    }
    Entry<String, Double> winner = null;
    for (Entry<String, Double> entry : onceLeaderBoard.entrySet()) {
      if (winner == null || winner.getValue() > entry.getValue()) {
        winner = entry;
      }
    }
    System.out.println(winner.getKey());
    putLeaderboards(winner);
  }
  
  public void putLeaderboards(Entry<String, Double> winner) {
    if(leaderboards.get(winner.getKey()) != null) {
      List<Double> records = leaderboards.get(winner.getKey());
      records.add(winner.getValue());
      leaderboards.put(winner.getKey(), records);
    } else {
      List<Double> records = new ArrayList<>();
      records.add(winner.getValue());
      leaderboards.put(winner.getKey(), records);
    }
  }
  
  public double countRaceTime(player thisPlayer) {
    double[] pauseRange = thisPlayer.getPauseRange();
    int stepDistance = thisPlayer.getStepDistance();
    int distance = raceDistance;
    double timer = 0;
    while (distance > 0 && (distance - stepDistance > 0)) {
      timer += 1 + getPauseTime(pauseRange);
      distance = distance - stepDistance;
    }
    if(distance > 0) { // 還有最後的一點路，小於stepDistance
      double speed = 1.0 /(double) stepDistance; // 跑一公尺要幾秒
      timer += distance*speed;
    }
    return timer;
  }
  
  public double getPauseTime(double[] pauseRange) {
    return (1 + ThreadLocalRandom.current().nextDouble(pauseRange[0], pauseRange[1]));
  }
  
  public void initPlayers() {
    player turtle = new player("烏龜", 1, new double[]{0.35,0.55});
    player pig = new player("小豬", 2, new double[]{0.35,3.5});
    player rabbit = new player("兔子", 3, new double[]{2.6,4.0});
    participants.add(turtle);
    participants.add(pig);
    participants.add(rabbit);
  }
}

class player {
  private String name;
  private int stepDistance;
  private double[] pauseRange;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getStepDistance() {
    return stepDistance;
  }
  public void setStepDistance(int stepDistance) {
    this.stepDistance = stepDistance;
  }
  public double[] getPauseRange() {
    return pauseRange;
  }
  public void setPauseRange(double[] pauseRange) {
    this.pauseRange = pauseRange;
  }
  public player(String name, int stepDistance, double[] pauseRange) {
    super();
    this.name = name;
    this.stepDistance = stepDistance;
    this.pauseRange = pauseRange;
  }
  
}

