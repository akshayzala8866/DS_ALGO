public class Counting_sort {

	public static int FindMaximum(int mArray[]) {
		int max = mArray[0];

		for (int i = 1; i < mArray.length; i++) {
			if (mArray[i] > max) {
				max = mArray[i];
			}
		}
		System.out.println("Maximum value is : " + max);
	}

	public static void main(String[] args) {
		int mArray[] = {2, 1, 3, 5, 3, 2, 1, 5, 9, 6, 4, 5, 8, 9};

		FindMaximum(mArray);
	}
}
