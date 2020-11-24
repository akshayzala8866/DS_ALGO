public class Merge_Sort_recursion {

	public static void PrintArray(int mArray[]) {
		System.out.println("");
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}

	public static void MergeSort_Partition(int mArray[], int lb, int mid, int ub) {
		int i = lb, j = mid + 1;
		int k = lb;
		int temp[] = new int[mArray.length];

		while (i <= mid && j <= ub) {
			if (mArray[i] <= mArray[j]) {
				temp[k] = mArray[i];
				i++;
			} else {
				temp[k] = mArray[j];
				j++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= ub) {
				temp[k] = mArray[j];
				k++;
				j++;
			}
		}

		if (j > ub) {
			while (i <= mid) {
				temp[k] = mArray[i];
				k++;
				i++;
			}
		}

		int index = lb;

		while (index < k) {
			mArray[index] = temp[index];
			index++;
		}
	}

	public static void MergeSort(int mArray[], int lb, int ub) {
		if (lb < ub) {
			int mid = (lb + ub) / 2;
			MergeSort(mArray, lb, mid);
			MergeSort(mArray, mid + 1, ub);

			MergeSort_Partition(mArray, lb, mid, ub);
		}
	}

	public static void main(String[] args) {
		int mArray[] = { 5, 4, 3, 2, 1 };
		
		System.out.println("Bofore Sorting : ");
		PrintArray(mArray);

		MergeSort(mArray, 0, mArray.length - 1);
		
		System.out.println("After Sorting : ");
		PrintArray(mArray);
	}
}