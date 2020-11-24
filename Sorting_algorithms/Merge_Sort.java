import java.util.*;

public class Merge_Sort {

	public static void Sorting(int mArray[], int l, int mid, int r) {
		int i = l, j = mid + 1, k = l;
		int temp[] = new int[mArray.length];
		while (i <= mid && j <= r) {
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
			while (j <= r) {
				temp[k] = mArray[j];
				j++;
				k++;
			}
		}
		if (j > r) {
			while (i <= mid) {
				temp[k] = mArray[i];
				k++;
				i++;
			}
		}
		int index = l;
		while (index <= r) {
			mArray[index] = temp[index];
			index++;
		}
	}

	public static void Divide(int mArray[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			Divide(mArray, l, mid);
			Divide(mArray, mid + 1, r);

			Sorting(mArray, l, mid, r);
		}
	}

	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			mArray[i] = s.nextInt();
		}
		Divide(mArray, 0, n - 1);
		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
}