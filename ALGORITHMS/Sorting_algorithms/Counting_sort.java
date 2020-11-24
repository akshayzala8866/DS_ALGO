public class Counting_sort {

	public static int FindMaximum(int mArray[]) {
		int max = mArray[0];

		for (int i = 1; i < mArray.length; i++) {
			if (mArray[i] > max) {
				max = mArray[i];
			}
		}
		return max;
	}

	public static void PrintArray(int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + "  ");
		}
		System.out.println("");
	}

	public static int[] CreateCountArray(int[] count_array, int[] mArray) {

		for (int i = 0; i < count_array.length; i++) {
			count_array[i] = 0;
		}

		for (int i = 0; i < mArray.length; i++) {
			++count_array[mArray[i]];
		}
		return count_array;
	}

	public static int[] AddingCountArray(int mArray[]) {
		for (int i = 1; i < mArray.length; i++) {
			mArray[i] += mArray[i - 1];
		}
		return mArray;
	}

	public static int[] CountingSort(int[] count_array, int[] mArray) {
		int temp[] = new int[mArray.length], j = 0;
		System.out.println("temp length : " + temp.length);

		for (int i = temp.length - 1;  i >= 0; i--) {
			// j = count_array[mArray[i]];
			// j = j - 1;
			// System.out.print(j + " ");
			// temp[j] = mArray[i];	
			temp[--count_array[mArray[i]]] = mArray[i];
		}
		System.out.println("");
		return temp;
	} 

	public static void main(String[] args) {
		int mArray[] = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};

		int max_value = FindMaximum(mArray);
		System.out.println("Maximum value is : " + max_value);

		int count_array[] = new int[max_value + 1];

		count_array = CreateCountArray(count_array, mArray);
		System.out.println("Count array is  :");
		PrintArray(count_array);

		count_array = AddingCountArray(count_array);
		System.out.println("after addition of count array : ");
		PrintArray(count_array);

 		mArray = CountingSort(count_array, mArray);
		System.out.println("After counting sort : ");
		PrintArray(mArray);
	}
}