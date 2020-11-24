import java.util.*;

public class Make_Valid_Equation {

	public static int[] Enter_Equation(int mArray[]) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter number : ");
		for (int i = 0; i < mArray.length; i++) {
			mArray[i] = s.nextInt();
		}

		return mArray;
	}

	public static void Print_result(int mArray[], char symbol[], int k) {
		System.out.println("k : " + k + " size : " + symbol.length);
		for (int i = 0; i < k - 2; i++) {
			System.out.print(symbol[i]);
		}
	}

	public static void Print_Equation(int mArray[], int k, int n, int result, char symbol[]) {
		int temp_result = result;
		System.out.println("k : " + k + " result : " + result);
		if (k == n) {
			System.out.println("Hi");
			if (result == mArray[n]) {
				Print_result(mArray, symbol, k);
			} else {
				 return;
			}
		}

		result = result + mArray[k]; // currenty result is 3
		symbol[k - 1] = '+';
		Print_Equation(mArray, k + 1, n, result, symbol);
		temp_result = temp_result - mArray[k];
		symbol[k - 1] = '-';
		Print_Equation(mArray, k + 1, n, result, symbol);
	}	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size : ");
		int size = s.nextInt();
		int mArray[] = new int[size];
		char symbol[] = new char[size - 2];

		mArray = Enter_Equation(mArray);
		Print_Equation(mArray, 1, mArray.length - 1, mArray[0], symbol);
	}
}