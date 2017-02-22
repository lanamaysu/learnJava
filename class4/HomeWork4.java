package class4;

import java.util.Arrays;

public class HomeWork4 {
  public static void main(String[] args) {
    new Q4_1().printAns();
  }
}



/**
 * <pre>
 * 有一個整數陣列，請幫我完成由大到小排序與小到大排序
 * { 100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10}
 * </pre>
 */
class Q4_1 {
  public void printAns() {
    System.out.println("有一個整數陣列，請幫我完成由大到小排序與小到大排序\n{100, 10, 7, 78, 87, 45, 32, 11, 10}");
    int[] array = {100 , 10 , 7 , 78 , 87 , 45 , 32 , 11 , 10};
    System.out.println("Ascending : " + Arrays.toString(sortAscending(array)));
    System.out.println("Descending: " + Arrays.toString(sortDescending(array)));
  }
  public int[] sortAscending(int[] array) {
    int arrLength = array.length;
    for(int i = arrLength; i >= 0; i--) {
      for(int j = 0; j < arrLength - 1; j++) {
        if(array[j] > array[j+1]) {
          swapNumber(j, j+1, array);
        }
      }
    }
   return array;
  }
  public int[] sortDescending(int[] array) {
    int arrLength = array.length;
    for(int i = 0; i < arrLength; i++) {
      for(int j = arrLength -1; j >0; j--) {
        if(array[j] > array[j-1]) {
          swapNumber(j, j-1, array);
        }
      }
    }
   return array;
  }
  public void swapNumber(int i, int j, int[] arr) {
    int tmp;
    tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}

/**
 * <pre>
 * 讓使用者輸入兩個數字
 * 並讓使用者選擇要使用 加減乘除 的功能
 * Hint: 必須使用到system.in 與 switch case
 * </pre>
 */
class Q4_2 {
  
}


/**
 * <pre>
 * 
 * 使用 switch 與 array
 * 印出 2007~2017 的年月日  
 * 
 * ex :
 * 2017
 * 1月
 * 1,2,3,4,....,31
 * 2月 
 * 1,2,3,....,29
 * 
 * Hint:建議初始化陣列平年與閏年每月的天數
 * 
 * </pre>
 */
class Q4_3 {
  
}


/**
 * <pre>
 * 這是一個小遊戲
 * 有一排數字1~100
 * 請使用者每次輸入100內的數字
 * 每次輸入完，需要印出輸入過的數字
 * 以及這個數字的在某個區間範圍內
 * 直到使用者猜到那個數字，程式停止
 * 需要使用While , Break 判斷
 * </pre>
 */
class Q4_4 {
  
}



