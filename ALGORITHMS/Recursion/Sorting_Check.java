public class Sorting_Check {

	public static boolean CheckArray(int mArray[], int length) {
		if (length == 1) {
			if (mArray[1] >= mArray[0]) {
				return true;
			} else {
				return false;
			}
		}

		if (mArray[length] < mArray[length - 1]) {
			return false;
		}

		return CheckArray(mArray, length - 1);
	}

	public static boolean CheckArray_Iterative(int mArray[], int length) {
		if (length == 0 || length == -1) {
			return true;
		}

		for (int i = 0; i < mArray.length - 1; i++) {
			if (mArray[i] < mArray[i + 1]) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int mArray[] = { 2, 4, 30 };

		if (CheckArray(mArray, mArray.length - 1)) {
			System.out.println("Yes :)");
		} else {
			System.out.println("No :(");
		}

		if (CheckArray_Iterative(mArray, mArray.length - 1)) {
			System.out.println("Iterative Yes :)");
		} else {
			System.out.println("Iterative No :(");
		}
	}
} 