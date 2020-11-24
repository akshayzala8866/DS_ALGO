public class Reverse_Array {

	public static int[] Reverse_Without_Recursion(int mArray[]) {
		int temp[] = new int[mArray.length];
		int counter = 0;

		for (int i = mArray.length - 1; i >= 0; i--) {
			temp[counter] = mArray[i];
			counter++;
		}

		return temp;
	}
  	
  	public static void PrintArray(int mArray[]) {

  		for (int i : mArray) {
			System.out.print(i + ", ");
		}

		System.out.println("");
  	} 

  	public static int[] Reverse_With_Recursion(int mArray[], int start, int end) {

  		if (start < end) {
  			int temp = mArray[start];
  			mArray[start] = mArray[end];
  			mArray[end] = temp;

  			Reverse_With_Recursion(mArray, start + 1, end - 1);
  		}

  		return mArray;
  	}

	public static void main(String[] args) {
		int mArray[] = { 1, 3, 2, 4, 10 };
		int temp[] = new int[mArray.length];

		System.out.println("Original array : ");

		PrintArray(mArray);

		mArray = Reverse_Without_Recursion(mArray);

		System.out.println("Reverse array : ");
		PrintArray(mArray);

		mArray = Reverse_With_Recursion(mArray, 0, mArray.length - 1);
		System.out.println("Reverse array : ");
		PrintArray(mArray);

	}
}