public class Sort_Two_Arrays {

	public static void PrintArray(int mArray[]) {
		System.out.println("");
		for (int i : mArray) {
			System.out.print(i + ",");
		}
		System.out.println("");
	}

	public static int[] SortArray(int mArray1[], int mArray2[], int mArray[]) {
		int i = 0, j = 0, index = 0;
		System.out.println("mArray size : " + mArray.length);

		while (i < mArray1.length && j < mArray2.length) {
			if (mArray1[i] <= mArray2[j]) {
				mArray[index] = mArray1[i];
				i++;
			} else {
				mArray[index] = mArray2[j];
				j++;
			}
			index++;
		}

		if (i >= mArray1.length) {
			while (j < mArray2.length) {
				mArray[index] = mArray2[j];
				j++;
				index++;
			}
		}

		if (j >= mArray2.length) {
			while (i < mArray1.length) {
				mArray[index] = mArray1[i];
				i++;
				index++;
			}
		}

		return mArray;
	}

	public static void main(String[] args) {
		int mArray1[] = { 11, 13, 15, 17, 19, 21 };
		int mArray2[] = { 12, 14, 16, 18, 20, 22 };
		int totlaLength = mArray1.length + mArray2.length; 
		int mArray[] = new int[totlaLength];

		mArray = SortArray(mArray1, mArray2, mArray);
		System.out.println("After sorting : ");
		PrintArray(mArray);
	}
}