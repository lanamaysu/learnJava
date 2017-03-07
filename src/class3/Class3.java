package class3;

public class Class3 {
  public static void main(String[] args) {
    MyIfElseIfElse myIfElseIfElse = new MyIfElseIfElse();
    System.out.println("isDivideBy2: " + myIfElseIfElse.isDivideBy2(5));
    System.out.println("multiDevide: " + myIfElseIfElse.isDivideBy2(30));
    MyFor myFor = new MyFor();
    myFor.testFor();
    System.out.println(myFor.multiply99());
    MyWhile myWhile = new MyWhile();
    myWhile.testWhile();
    System.out.println("\ndo while");
    MyDoWhile myDoWhile = new MyDoWhile();
    myDoWhile.multiplyTable();
    MyArray myArray = new MyArray();
    myArray.printMultiplyArray();
    System.out.println(myArray.initCardArray());
  }
}


class MyIfElseIfElse {
  public boolean isDivideBy2(int num) {
    if ((num % 2) == 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean multiDevide(int num) {
    if ((num % 2 == 0) && (num % 3 == 0) && (num % 5 == 0)) {
      return true;
    } else {
      return false;
    }
  }
}


class MyFor {
  public int[] testFor() {
    int[] testArray = new int[10];

    for (int index = 0; index < testArray.length; index++) {
      testArray[index] = index;
      System.out.println("testArray[" + index + "] = " + testArray[index]);
    }

    return testArray;
  }

  public String multiply9(int num) {
    int[] tenIntArray = new int[9];
    String oneLine = "";
    for (int i = 0; i < tenIntArray.length; i++) {
      int tmpInt = i + 1;
      tenIntArray[i] = num * tmpInt;
      oneLine += num + "*" + tmpInt + "=" + tenIntArray[i] + "; ";
    }
    return oneLine;
  }

  public String multiply99() {
    String multiLine = "";
    for (int i = 0; i < 9; i++) {
      multiLine += multiply9(i + 1) + "\n";
    }
    return multiLine;
  }
}


class MyWhile {
  public void testWhile() {
    int i = 1;
    while (i < 10) {
      System.out.print("1*" + i + "=" + i * 1);
      if (i < 9) {
        System.out.print(",");
      }
      i++;
    }
  }
}


class MyDoWhile {
  public void testDoWhile() {
    System.out.println("題目 :　1*1=1 , 1*2=2 ...... 1*9=9");
    int i = 1;
    do {
      System.out.print("1*" + i + "=" + 1 * i);
      if (i < 9) {
        System.out.print(",");
      }
      i++; // => i = i + 1;
    } while (i < 10);
    System.out.println();
  }

  // 練習 : 請用 do while 寫九九乘法表
  public void multiplyTable() {
    int i = 1;
    String oneline;
    do {
      oneline = "";
      int j = 1;
      do {
        oneline += i + "*" + j + "=" + i * j + "\t";
        j++;
      } while (j < 10);
      System.out.println(oneline);
      i++;
    } while (i < 10);
  }
}


class MyArray {
  int[] oneArray;
  int[][] twoArray;

  String[] oneStringArray;
  String[][] twoStringArray;

  public void initOneArray(int size) {
    oneArray = new int[size];
    for (int i = 0; i < size; i++) {
      oneArray[i] = i;
    }
  }

  // 練習1 : 請使用雙層迴圈，把1~9放到二維陣列
  public int[][] initMultiplyArray() {
    int[][] multiplyArray = new int[9][9];
    for (int i = 0; i < multiplyArray.length; i++) {
      for (int j = 0; j < multiplyArray[i].length; j++) {
        multiplyArray[i][j] = j + 1;
      }
    }
    return multiplyArray;
  }

  // 練習2 : 二維陣列初始完畢，請陣列內的數字
  // 印出九九乘法表
  public void printMultiplyArray() {
    System.out.println("二維陣列");
    int[][] arr = initMultiplyArray();
    String oneline = "";
    for (int i = 0; i < arr.length; i++) {
      oneline = "";
      for (int j = 0; j < arr[i].length; j++) {
        oneline += (i + 1) + "*" + arr[i][j] + "=" + (i + 1) * arr[i][j] + "\t";
      }
      System.out.println(oneline);
    }
  }

  // 花色
  public void initOneStringArray() {
    oneStringArray = new String[4];
    oneStringArray[0] = "梅花";
    oneStringArray[1] = "方塊";
    oneStringArray[2] = "愛心";
    oneStringArray[3] = "黑桃";
  }

  // 練習3 : 請練習發初始二維陣列，放入52張牌
  public String[][] initCardArray() {
    String[][] cardArr = new String[4][13];
    for (int i = 0; i < cardArr.length; i++) {
      for (int j = 0; j < cardArr[i].length; j++) {
        cardArr[i][j] = oneStringArray[i] + Integer.toString(j + 1);
      }
    }
    return cardArr;
  }

}
