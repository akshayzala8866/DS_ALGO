public class Insertion_Sort {

	public static void PrintArray(int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + "  ");
		}
		System.out.println("");
	}

	public static void InsertionSort(int mArray[]) {
		int temp = 0, j = 0;

		for (int i = 1; i < mArray.length; i++) {
			temp = mArray[i];
			j = i - 1;

			while (j >= 0 && mArray[j] > temp) {
				mArray[j + 1] = mArray[j];
				j--;
			} 
			mArray[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int mArray[] = {64, 25, 12, 22, 11};

		System.out.println("Before sorting..!!");
		PrintArray(mArray);
		InsertionSort(mArray);
		System.out.println("After sorting..!!");
		PrintArray(mArray);
	}
}