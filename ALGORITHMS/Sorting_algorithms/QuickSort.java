import java.util.*;

public class QuickSort {

	public static int QuickSort(int mArray[], int l, int r) {
		int i = l, j = r, temp = 0;
		int p = mArray[l];
		while (i <= j) {
			while (mArray[i] <= p && i < r) {
				i++;
			}
			while (mArray[j] > p && j < l) {
				j++;
			}
			if (i <= j) {
				temp = mArray[i];
				mArray[i] = mArray[j];
				mArray[j] = temp;
			}
		}
		temp = mArray[j];
		mArray[j] = mArray[l];
		mArray[l] = temp;

		return j;
	} 

	public static void Divide(int mArray[], int l, int r) {
		if (l < r) {
			int p = QuickSort(mArray, l, r);
			Divide(mArray, l, p - 1);
			Divide(mArray, p + 1, r);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			mArray[i] = s.nextInt();
		}
		Divide(mArray, 0, mArray.length - 1);
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
}