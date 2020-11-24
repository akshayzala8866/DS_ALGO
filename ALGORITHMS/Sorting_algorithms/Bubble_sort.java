import java.util.Scanner;

public class Bubble_sort {

	public static void DisplaySortedArray(int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + ", ");
		}
		System.out.println("");

	}

	public static void BubbleSort(int mArray[]) {
		int temp = 0;

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray.length - i - 1; j++) {
				if (mArray[j] > mArray[j + 1]) {
					temp = mArray[j + 1];
					mArray[j + 1] = mArray[j];
					mArray[j] = temp;
				}
			}
		}

		DisplaySortedArray(mArray);
	}

	public static void main(String[] args) {

		Bubble_sort obj = new Bubble_sort();

		Scanner s = new Scanner(System.in);
		int size = 0;

		System.out.println("Enter size of the array : ");
		size = s.nextInt();

		int mArray[] = new int[size];

		System.out.println("Enter data into array : ");
		for (int i = 0; i < mArray.length; i++) {
			mArray[i] = s.nextInt();
		}

		BubbleSort(mArray);
	}
}