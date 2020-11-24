public class Bubble_Sort_Recursive {

	public static int[] BubbleSort(int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray.length - i - 1; j++) {
				if (mArray[j] > mArray[j + 1]) {
					int temp = mArray[j];
					mArray[j] = mArray[j + 1];
					mArray[j + 1] = temp;
				}
			}
		}

		return mArray;
	}
	public static void PrintArray(int mArray[]) {
		System.out.println("");
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println("");

	}

	public static int[] BubbleSort_Recursin(int mArray[], int length) {
		if (length == 1) {
			return mArray;
		}

		for (int i = 0; i < length - 1; i++) {
			if (mArray[i] > mArray[i + 1]) {
				int temp = mArray[i];
				mArray[i] = mArray[i + 1];
				mArray[i + 1] = temp;
			}
		}

		return BubbleSort_Recursin(mArray, length - 1);
	}

	public static void BinarySearch_recursion(int mArray[], int start, int end, int ans) {
		if (start < end) {
			int mid = (start + end) / 2;

			if (mArray[mid] == ans) {
				System.out.println("index : " + mid);
			} else if (ans <= mArray[mid]) {
				BinarySearch_recursion(mArray, start, mid - 1, ans);
			} else {
				BinarySearch_recursion(mArray, mid + 1, end, ans);
			}
		}
	}

	public static boolean Sorting_Check(int mArray[], int length) {
		if (length == 1) {
			if (mArray[length] < mArray[length - 1]) {
				return false;
			} else {
				return true;
			}
		}

		return Sorting_Check(mArray, length - 1);
	}

	public static void main(String[] args) {
		int mArray[] = { 64, 34, 25, 12, 22, 11, 90 };

		mArray = BubbleSort(mArray);
		PrintArray(mArray);

		mArray = BubbleSort_Recursin(mArray, mArray.length);
		System.out.println("With recursion : ");
		PrintArray(mArray);

		BinarySearch_recursion(mArray, 0, mArray.length - 1, 12);

		if (Sorting_Check(mArray, mArray.length - 1)) {
			System.out.println("Yes :)");
		} else {
			System.out.println("No :(");
		}
 	}
}