import java.util.*;

public class BinarySearch {

	public int[] shortArray(int mArray[]) {
		int min = 0, temp = 0;

		for (int i = 0; i< mArray.length - 1; i++) {
			min = i;
			for (int j = i+1; j < mArray.length; j++ ) {
				if (mArray[j] < mArray[min]) {
					min = j;
				}
			}
			temp = mArray[min];
			mArray[min] = mArray[i];
			mArray[i] = temp;
		}

		return mArray;
	}

	public int Binary_Search(int mArray[], int lb, int up, int data) {

		while (lb <= up) {
			int mid = (lb + up) / 2;

			if (mArray[mid] == data) {
				return mid;
			} else if (data > mArray[mid]) {
				return Binary_Search(mArray, mid + 1, up, data);
			} else {
				return Binary_Search(mArray, lb, mid - 1, data);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinarySearch obj = new BinarySearch();
		int ch = 0, data = 0;
		int mArray[] = new int[5];

		while (true) {
			System.out.println("1. Add");
			System.out.println("2. Search");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter elements : ");

					for (int i = 0; i < mArray.length; i++) {
						mArray[i] = s.nextInt();
					}

					System.out.println("Elements are : ");

					for (int i : mArray) {
						System.out.print(i + ", ");
					}
					System.out.println("");

					mArray = obj.shortArray(mArray);

					System.out.println("Sorted array : ");
					
					for (int i : mArray) {
						System.out.print(i + ", ");
					}
					System.out.println("");

					break;

				} case 2: {
					System.out.println("Enter data :");
					data = s.nextInt();

					int index = obj.Binary_Search(mArray, 0, mArray.length - 1, data);

					if (index == -1) {
						System.out.println("Data is not present in array :(");
					} else {
						System.out.println(data + " is at " + index);
					}
				}
			}
		}
	}
}