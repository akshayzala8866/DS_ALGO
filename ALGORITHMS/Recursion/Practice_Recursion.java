import java.util.*;
	
public class Practice_Recursion {

	public static int bit = 4;

	public static void PrintBits(int mArray[]) {
		for (int i : mArray) {
			System.out.print(i);
		}
		System.out.println("");
	}
 
	public static void FindBinary(int mArray[], int n) {
		if (n == mArray.length) {
			PrintBits(mArray);
			return;
		}

		mArray[n] = 0;
		FindBinary(mArray, n + 1);

		mArray[n] = 1;
		FindBinary(mArray, n + 1);

	}

	public static void main(String[] args) {
		
		int mArray[] = new int[bit];
		FindBinary(mArray, 0);
	}	
}