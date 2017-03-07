package class4;

import java.util.Random;
import java.util.Scanner;

public class Class4 {
  public static void main(String[] args) {
    MyOtherIfElse myOtherIfElse = new MyOtherIfElse();
    myOtherIfElse.canBeDivided(30);
    new MySystemIn().inputWhile();
  }
}


// 交換
class MySwapNum {
  public void swapNumber(int headNum, int footNum) {
    System.out.println("交換前 : " + headNum + " , " + footNum);
    int temp = headNum;
    headNum = footNum;
    footNum = temp;
    System.out.println("交換後 : " + headNum + " , " + footNum);
  }
}


// 三元運算
class MyOtherIfElse {
  public void isDivide2(int num) {
    System.out.println("num = " + num + "是否可被2整除" + (num % 2 == 0 ? true : false));
  }

  public void isTom(String str) {
    System.out.println("Name is " + str + ". is Tom ? " + ("Tom".equals(str) ? true : false));
  }

  // 練習，傳入一個數字，回傳是否可以被 2 3 5整除，請使用三元運算
  public void canBeDivided(int num) {
    System.out.println(num + " can be devided by 2,3,5 :"
        + (num % 2 == 0 && num % 3 == 0 && num % 5 == 0 ? true : false));
  }

}


class MySystemIn {
  Scanner scanner = new Scanner(System.in);

  public void input() {
    System.out.print("Please input your name: ");
    System.out.printf("Hello! %s!", scanner.next());
  }

  // 練習 請使用While無窮迴圈，讓使用者持續輸入文字，直到輸入0，結束程式
  public void inputWhile() {
    boolean flag = true;
    while (flag) {
      System.out.print("Please input a number: ");
      String s = scanner.next();
      System.out.println("your number is " + s);
      if ("0".equals(s)) {
        flag = false;
        System.out.printf("input end");
      }
    }
  }

}


class MySwtichCase {
  public void MyNumberSwtichCase(int num) {
    switch (num) {
      case 0:
        System.out.println("Hello world");
        break;
      default:
        System.out.println("WTF??");
        break;
    }
  }

  public void MyStringSwitchCase(String str) {
    switch (str) {
      case "Tom":
        System.out.println("WelCome Back Admin , " + str);
        break;
      default:
        System.out.println("Hi , " + str);
        break;
    }
  }
}


class MyRandom {
  public void random(int size) {
    Random ran = new Random();
    String str = "";
    for (int i = 1; i < size; i++) {
      str += Integer.toString(ran.nextInt(size) + 1);
      if (i < size - 1) {
        str += ",";
      }
    }
    System.out.println(str);
  }
}


class MyBreakContinue {
  public void test1() {
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        continue;
      }
      if (i % 7 == 0) {
        break;
      }
      System.out.println(" i = " + i);
    }
  }
}
