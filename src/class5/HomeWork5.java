package class5;

public class HomeWork5 {
  public static void main(String[] args) {
    new Q5_1().doMethods();
  }
}



/**
 * <pre>
 *  
 *  使用String與StringBuffer,StringBuilder
 *  I have a pen. 修改成 I have an apple.
 *  
 *  把兩段敘述串聯在一起
 *  =>
 *  I have a pen. I have an apple.
 * </pre>
 */
class Q5_1 {
  String pen = "I have a pen.";
  String apple = "I have an apple.";
  public void doMethods() {
    PPAPString();
    PPAPStringBuffer();
    PPAPStringBuilder();
  }
  public void PPAPString() {
    String str = pen;
    System.out.println("original:\t" + str);
    str = apple;
    System.out.println("modified:\t" + str);
    str = pen + " " + apple;
    System.out.println("concate:\t" + str + "\n");
  }
  public void PPAPStringBuffer() {
    StringBuffer strbf = new StringBuffer();
    strbf.append(pen);
    System.out.println("original:\t" + strbf.toString());
    strbf.delete(0, strbf.length());
    strbf.append(apple);
    System.out.println("modified:\t" + strbf.toString());
    strbf.delete(0, strbf.length());
    strbf.append(pen).append(" ").append(apple).append("\n");
    System.out.println("concate:\t" + strbf.toString());
  }
  public void PPAPStringBuilder() {
    StringBuffer sb = new StringBuffer();
    sb.append(pen);
    System.out.println("original:\t" + sb.toString());
    sb.delete(0, sb.length());
    sb.append(apple);
    System.out.println("modified:\t" + sb.toString());
    sb.delete(0, sb.length());
    sb.append(pen).append(" ").append(apple).append("\n");
    System.out.println("concate:\t" + sb.toString());
  }
}


/**
 * <pre>
 *  使用Date物件與Calendar物件
 *  計算下一個年度的4/1
 *  還有多少天
 *  印出那天的日期
 * </pre>
 */
class Q5_2 {
  public void calcDaysUntil() {
    
  }
}


/**
 * <pre>
 *  使用Calendar
 *  實作出2017年的日曆表
 *  EX :
 *  2017 3月
 *  日 ㄧ 二  三  四  五  六
 *             1   2   3   4
 *   5  6  7   8   9  10  11
 *   .......................
 *   .................31
 * </pre>
 */
class Q5_3 {

}


/**
 * <pre>
 *  
 *  使用BigDecimal版本
 *  讓使用者輸入兩個數字
 *  並讓使用者選擇要使用 加減乘除 的功能
 *  Hint: system.in, switch case
 * </pre>
 */
class Q5_4 {

}


