import java.util.*;

public class Sum_Of_Array_Elements {

	public static int Sum(int mArray[], int length) {
		
		//base case..
		if (length == 1) {
			return mArray[0];
		}

		return (Sum(mArray, (length - 1)) + mArray[length - 1]); 
	}
	
	public static void main(String[] args) {
		int mArray[] = {2, 3, 1, 23, 10};

		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		System.out.println("sum of elements are : " + Sum(mArray, mArray.length));
	}
}