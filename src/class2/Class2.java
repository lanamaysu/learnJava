package class2;

public class Class2 {

  public static void main(String[] args) {
    BasicType basicType = new BasicType();
    System.out.println("1 + 1 = " + basicType.plus());
    System.out.println("1 - 1 = " + basicType.minus());
    System.out.println("1 / 1 = " + basicType.devide());
    System.out.println("1 * 10 = " + basicType.multiply());
    System.out.println("( 1 + 1 ) / 1 =" + basicType.calculateA());
    // System.out.println("10 * 1 / 0 =" + basicType.calculateB()); //runtime error (不能/0)
    System.out.println("int == float: " + basicType.testCaseA());
    System.out.println("double == float: " + basicType.testCaseB());
    System.out.println("int == double: " + basicType.testCaseC());

    Cat cat1 = new Cat();
    Cat cat2 = new Cat();
    cat1.name = "0";
    cat1.number = 0;
    cat2.name = "0";
    // System.out.println(cat1.name.equals(cat1.number));
    System.out.println(cat1.name.equals(cat2.name));
    System.out.println(cat1.name == cat2.name);
    System.out.println(cat1.name);
    cat2 = cat1; // 指向同一個記憶體位置
    cat2.name = "QQ";
    System.out.println(cat1.name);
  }

}


// 基本資料型態 primitive data type
class BasicType {
  // 正整數
  int iAmInt;
  // 浮點數
  float iAmFloat;
  // 雙倍精度浮點數
  double iAmDouble;
  // 布林值
  boolean iAmBool;
  // 兩個星號+一個星號產生javadoc

  /** 1 + 1 */
  public int plus() {
    iAmInt = 1;
    return iAmInt + 1;
  }

  /** 1 - 1 */
  public int minus() {
    iAmInt = 1;
    return iAmInt - 1;
  }

  /** 1 / 1 */
  public int devide() {
    iAmInt = 1;
    return iAmInt / 1;
  }

  /** 1 * 10 */
  public int multiply() {
    iAmInt = 1;
    return iAmInt * 10;
  }

  /** ( 1 + 1 ) / 1 */
  public int calculateA() {
    iAmInt = 1;
    return (iAmInt + iAmInt) / 1;
  }

  /** 10 * 1 / 0 */
  public int calculateB() {
    iAmInt = 1;
    return (10 * iAmInt) / 0;
  }

  // int == float , 1 == 1
  public boolean testCaseA() {
    iAmInt = 1;
    iAmFloat = 1;
    return iAmInt == iAmFloat;
  }

  // float == double , 1 == 1
  public boolean testCaseB() {
    iAmFloat = 1;
    iAmDouble = 1;
    return iAmDouble == iAmFloat;
  }

  // int == double , 1 == 1.0
  public boolean testCaseC() {
    iAmInt = 1;
    iAmDouble = 1;
    return iAmInt == iAmDouble;
  }

}


// name => equals
// object => equals
// name => ==
// object => ==
class Cat {
  public String name;
  public int number;
}


// 區域與全域變數
class GlobalAndLocal {
  int a = 5; // 全域

  public int b() {
    int b = 10; // 區域
    return b;
  }
}


class TheArray {
  // 一維陣列
  int[] oneArray;
  // 二維陣列
  int[][] twoArray;
}
