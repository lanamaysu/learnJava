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
		if ( (num % 2 == 0) && (num % 3 == 0) && (num % 5 == 0) ) {
			return true;
		} else {
			return false;
		}
	}
}

class MyFor {
	public int [] testFor() {
		int [] testArray = new int[10];
		
		for(int index = 0; index < testArray.length; index++) {
			testArray[index] = index;
			System.out.println("testArray[" + index + "] = " + testArray[index]);
		}
		
		return testArray;
	}
	public String multiply9(int num) {
		int [] tenIntArray = new int[9];
		String oneLine = "";
		for(int i = 0; i < tenIntArray.length; i++) {
			int tmpInt = i+1;
			tenIntArray[i] = num*tmpInt;
			oneLine += num + "*" + tmpInt + "=" + tenIntArray[i] + "; ";
		}
		return oneLine;
	}
	public String multiply99() {
		String multiLine = "";
		for(int i = 0; i < 9; i++) {
			multiLine += multiply9(i+1) + "\n";
		}
		return multiLine;
	}
}

class MyWhile {
	public void testWhile() {
		int i = 1;
		while(i < 10) {
			System.out.print("1*" + i + "=" + i*1);
			if(i<9) {
				System.out.print(",");
			}
			i++;
		}
	}
}

class myDoWhile {

}

class myArray {
	int[] oneArray;
	int[][] twoArray;
}