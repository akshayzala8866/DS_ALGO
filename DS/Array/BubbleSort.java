import java.util.Scanner;

public class BubbleSort {

	public static void Bubblesort(int mArray[], int size) {
		int temp = 0;
		for (int i = 0; i < mArray.length; i++) {
			for(int j = 0; j < mArray.length - i - 1; j++) {
				if (mArray[j] > mArray[j+1]) {
					temp = mArray[j];
					mArray[j] = mArray[j + 1];
					mArray[j + 1] = temp;
				}	
			}
		}

		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + " ");
		}
	}

	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter array size");
		int size = s.nextInt();

		int mArray[] = new int[size];

		System.out.println("Enter elements : ");

		for (int i=0; i<mArray.length; i++) {
			mArray[i] = s.nextInt();
		}

		Bubblesort(mArray, mArray.length);
	}
}