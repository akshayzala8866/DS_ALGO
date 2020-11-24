public class QuickSort_Recursion {

	public static int QuickSort(int mArray[], int lb, int ub) {
		int start = lb, end = ub, temp = 0;
		int pivote = mArray[lb];

		while (start < end) {
			while (mArray[start] <= pivote && start < ub) {
				start++;
			} 

			while (mArray[end] > pivote) {
				end--;
			}

			if (start < end) {
				temp = mArray[start];
				mArray[start] = mArray[end];
				mArray[end] = temp;
			}
		}

		temp = mArray[end];
		mArray[end] = mArray[lb];
		mArray[lb] = temp;

		return end;
	}

	public static int[] QuickSort_Partition(int mArray[], int start, int end) {
		
		if (start < end) {
			int pivote_position = QuickSort(mArray, start, end);
			QuickSort_Partition(mArray, start, pivote_position - 1);
			QuickSort_Partition(mArray, pivote_position + 1, end);
		}

		return mArray;
	}

	public static void main(String[] args) {
		int mArray[] = { 64, 34, 25, 12, 22 };

		System.out.println("Before quick sort : ");
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		mArray = QuickSort_Partition(mArray, 0, mArray.length - 1);  
		
		System.out.println("After quick sort : ");
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
	}
}