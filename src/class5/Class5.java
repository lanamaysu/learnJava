package class5;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Class5 {
  public static void main(String[] args) {
    // indexOf
    System.out.println("X出現的位置 => " + "XXXX".indexOf("X"));
    System.out.println("空白也可以支援 => " + "XX X".indexOf(" "));
    System.out.println("不存在時 => " + "XX1X".indexOf("2"));
    // replace
    System.out.println("XXXX".replace("X", "*"));
    System.out.println("XXXX".replaceFirst("X", "*"));
    System.out.println("XXXX".replaceAll("X", "*"));


    System.out.println("--------------------");
    System.out.println("Date方法");
    MyDate date = new MyDate();
    date.showCommonDate();
    date.showFormatTime();

    System.out.println("--------------------");
    System.out.println("BigDecimal方法");
    MyBigDecimal bigDecimal = new MyBigDecimal();
    bigDecimal.showCompute("1", "2");
    bigDecimal.trick();

    System.out.println("--------------------");
    System.out.println("Calendar方法");
    MyCalendar calendar = new MyCalendar();
    calendar.defaultSet();
    calendar.testBetween();
  }
}

/**
 * <pre>
 * Java內建的時間物件
 *  after(Date when) : 檢查日期物件時間是否在本物件後 (true/false)   
 *  before(Date when) : 檢查日期物件時間是否在本物件前 (true/false)   
 *  getTime() : 傳回自 1970/1/1 以來之毫秒數
 *  setTime(int ms) : 將時間設定為 1970/1/1 後之毫秒數
 *  toString() : 把 Date 物件轉成字
 * </pre>
 */
class MyDate {
  public void showCommonDate() {
    Date now = new Date(); // 建立目前時間之 Date 物件
    System.out.println(now.getTime());
    System.out.println(System.currentTimeMillis());
    System.out.println(now.toString()); // 輸出 時間日期格式
    Date before = new Date(1); // 建立時間戳記為 1ms 之 Date 物件 (自 1970/1/1)
    System.out.println(before.before(now)); // 輸出 true
    System.out.println(now.before(before)); // 輸出 false
    System.out.println(before.after(now)); // 輸出 false
    System.out.println(now.after(before)); // 輸出 true
    before.setTime(4396267507921L); // 須為長整數
    System.out.println(now.after(before)); // 輸出 false
  }

  public void showFormatTime() {
    // 直接格式化輸出現在時間的方法
    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date current = new Date();
    System.out.println(sdFormat.format(current));
  }
}


/**
 * <pre>
 * 加減乘除與比較的功能
 * </pre>
 */
class MyBigDecimal {

  public void showCompute(String num1, String num2) {
    System.out
        .println(num1 + " + " + num2 + " = " + new BigDecimal(num1).add(new BigDecimal(num2)));
    System.out
        .println(num1 + " - " + num2 + " = " + new BigDecimal(num1).subtract(new BigDecimal(num2)));
    System.out
        .println(num1 + " * " + num2 + " = " + new BigDecimal(num1).multiply(new BigDecimal(num2)));
    System.out
        .println(num1 + " / " + num2 + " = " + new BigDecimal(num1).divide(new BigDecimal(num2)));
    System.out.println(
        num1 + " compare to " + num2 + " = " + new BigDecimal(num1).compareTo(new BigDecimal(num2)));
  }

  // 初始化陷阱
  public void trick() {
    System.out.println("1.25959 float  => " + new BigDecimal(1.25959));
    System.out.println("1.25959 Double => " + new BigDecimal(new Double(1.25959)));
    System.out.println("1.25959 String => " + new BigDecimal("1.25959"));
  }

}


/**
 * <pre>
 * Calendar實作做加減的運算
 * 輸出的時候getTime得到date物件再format
 * </pre>
 */
class MyCalendar {

  public void defaultSet() {
    Calendar c = Calendar.getInstance();
    c.set(2017, 11, 12); // 設定日期為2017年11月12日，
    System.out.println("初始時間:" + format(c)); // 在Calendar類別中月份的編號是由0~11

    c.set(Calendar.YEAR, 2013); // 將年改成2013年
    System.out.println("修改年份:" + format(c));

    c.set(Calendar.MONTH, Calendar.JANUARY); // 將月份改成1月
    System.out.println("修改月份:" + format(c));

    c.set(Calendar.DAY_OF_MONTH, 31); // 將日改成31日
    System.out.println("修改日期:" + format(c));

    // 時間是24小時制
    c.set(Calendar.HOUR_OF_DAY, 18); // 將hour改成下午六點
    System.out.println("修改時間:" + format(c));

    c.set(Calendar.AM_PM, Calendar.PM); // 將hour改成下午六點
    System.out.println("修改時間:" + format(c));

    c.set(Calendar.HOUR, 6);
    System.out.println("修改時間:" + format(c));

  }

  // calendar可以轉型成date
  // 並使用SimpleDateFormat
  // 進行時間的格式化
  private String format(Calendar calendar) {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date date = calendar.getTime();
    return df.format(date);
  }

  public void testBetween() {
    Calendar birth = Calendar.getInstance();
    birth.set(1986, Calendar.FEBRUARY, 6);
    Calendar now = Calendar.getInstance();
    System.out.println(daysBetween(birth, now) + "天");
    System.out.println(daysBetween(birth, now) + "天");
  }

  private long daysBetween(Calendar begin, Calendar end) {
    Calendar calendar = (Calendar) begin.clone(); // clone的時候前面要小括號包物件類型
    long daysBetween = 0;
    while (calendar.before(end)) {
      calendar.add(Calendar.DAY_OF_MONTH, 1);
      daysBetween++;
    }
    return daysBetween;
  }


}
