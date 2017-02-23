package class4;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork4 {
	public static void main(String[] args) {
		// new Q4_1().printAns();
		// new Q4_2().input();
		// new Q4_3().printCalendar();
		new Q4_4().input(1, 100);
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
		int[] array = { 100, 10, 7, 78, 87, 45, 32, 11, 10 };
		System.out.println("Ascending : " + Arrays.toString(sortAscending(array)));
		System.out.println("Descending: " + Arrays.toString(sortDescending(array)));
	}

	public int[] sortAscending(int[] array) {
		int arrLength = array.length;
		for (int i = arrLength; i >= 0; i--) {
			for (int j = 0; j < arrLength - 1; j++) {
				if (array[j] > array[j + 1]) {
					swapNumber(j, j + 1, array);
				}
			}
		}
		return array;
	}

	public int[] sortDescending(int[] array) {
		int arrLength = array.length;
		for (int i = 0; i < arrLength; i++) {
			for (int j = arrLength - 1; j > 0; j--) {
				if (array[j] > array[j - 1]) {
					swapNumber(j, j - 1, array);
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
	public void input() {
		System.out.println("EASY CALCULATOR START");
		System.out.print("\tPlease enter a number: ");
		int num1 = numberInput();
		System.out.print("\tPlease enter another number: ");
		int num2 = numberInput();
		String operator;
		boolean getResult = false;
		while (!getResult) {
			operator = operatorInput();
			getResult = result(num1, num2, operator);
		}
		System.out.println("EASY CALCULATOR END");
	}

	public int numberInput() {
		Scanner sc = new Scanner(System.in);
		int number;
		while (!sc.hasNextInt()) {
			System.out.print("\tThat's not a number! Please try again: ");
			sc.next();
		}
		number = sc.nextInt();
		return number;
	}

	public String operatorInput() {
		System.out.print("\tPlease enter an operator (+-*/ or in english): ");
		Scanner sc = new Scanner(System.in);
		String operator = sc.next();
		return operator;
	}

	public boolean result(int num1, int num2, String operator) {
		switch (operator) {
		case "+":
		case "add":
			System.out.printf("\tResult: %d + %d = %d\n", num1, num2, (num1 + num2));
			return true;
		case "-":
		case "minus":
			System.out.printf("\tResult: %d - %d = %d\n", num1, num2, (num1 - num2));
			return true;
		case "*":
		case "multiply":
			System.out.printf("\tResult: %d * %d = %d\n", num1, num2, (num1 * num2));
			return true;
		case "/":
		case "devide":
			System.out.printf("\tResult: %d * %d = %f\n", num1, num2, (num1 / num2));
			return true;
		default:
			System.out.println("\tOperator not found, please try again");
			return false;
		}
	}
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
	public int[] years(int startY, int endY) {
		int[] yearsArray = new int[(endY - startY)];
		for (int i = startY; i < endY; i++) {
			yearsArray[i - startY] = i;
		}
		return yearsArray;
	}

	public boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
	}

	public int monthDays(int year, int month) {
		switch (month) {
		case 2:
			return isLeapYear(year) ? 29 : 28;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 11:
		case 12:
			return 31;
		default:
			return 30;
		}
	}

	public void printCalendar() {
		System.out.println("使用 switch 與 array 印出 2007~2017 的年月日");
		int[] yearsArray = years(2007, 2017);
		int thisYear;
		int thisMonthDays;
		String oneLineDays;
		for (int i = 0; i < yearsArray.length; i++) {
			thisYear = yearsArray[i];
			System.out.println(thisYear);
			for (int month = 1; month <= 12; month++) {
				System.out.println(month + "月");
				thisMonthDays = monthDays(thisYear, month);
				oneLineDays = "";
				for (int days = 1; days <= thisMonthDays; days++) {
					oneLineDays += (days == 1 ? days : ("," + days));
				}
				System.out.println(oneLineDays);
			}
		}
	}
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
	int lowerBound;
	int upperBound;
	public void input(int min, int max) {
		lowerBound = min;
		upperBound = max;
		System.out.printf("Please enter a number between %d and %d\n", min, max);
		int inputInt;
		int ans = genRandomInt(min, max);
		int guessTimes = 0;
		String inputNums = "";
		boolean getResult = false;
		while (!getResult) {
			guessTimes++;
			System.out.printf("===== Round %d =====\n", guessTimes);
			inputInt = numberInput(min, max);
			inputNums += inputInt + ",";
			getResult = result(inputInt, ans, guessTimes, inputNums);
		}
	}

	public int genRandomInt(int min, int max) {
		return min + new Random().nextInt(max + 1);
	}

	public int numberInput(int min, int max) {
		System.out.print("Input your guess number: ");
		Scanner sc = new Scanner(System.in);
		int number;
		while (!sc.hasNextInt()) {
			System.out.print("Type error! Please input an integer: ");
			sc.next();
		}
		number = sc.nextInt();
		while (number < min || number > max) {
			System.out.printf("Input out of boundary! It's between %d and %d: ", min, max);
			number = sc.nextInt();
		}
		return number;
	}

	public boolean result(int input, int ans, int guessTimes, String inputNums) {
		if(input == ans) {
			System.out.println("Congrats! You did it!");
			System.out.printf("The answer is %d, you guessed %d times in total.\n", ans, guessTimes);
			System.out.printf("All guesses you've done: " + inputNums.substring(0,inputNums.length()-1));
			return true;
		} else {
			if(input < ans) {
				lowerBound = input;
			} else {
				upperBound = input;
			}
			System.out.printf("Booooo! It's between %d and %d. Try it again!\n", lowerBound, upperBound);
			return false;
		}
	}
}