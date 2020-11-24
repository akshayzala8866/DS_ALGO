import java.util.*;

public class Stake_Sorting {

	static int mArray[] = new int[5];
	static int top = -1;

	public static int[] push(int mArray[], int data) {

		if (top == mArray.length - 1) {
			System.out.println("Over flow");
		} else {
			++top;
			mArray[top] = data;
		}

		return mArray;
	}

	public static void DisplayStake(int mArray[]) {
		int temp = 0;

		if (top == -1) {
			System.out.println("Empty :("); 
		} else {
			while (temp <= top) {
				System.out.print(mArray[temp] + "  ");
				temp++;
			}
			System.out.println("");
			System.out.println("Top of the stake is : " + mArray[top]);
		}
	}

	public static int[] pop(int mArray[]) {
		if (top == -1) {
			System.out.println("Under flow condition ");
		} else {
			top--;
		}
		return mArray;
	} 

	public static int[] SortStack(int mArray[]) {
		if (top == -1) {
			System.out.println("Empty :(");
		} else {
			for (int i = 1; i <= top; i++) {
				int temp = mArray[i];
				int j = i - 1;

				while (j >= 0 && mArray[j] > temp) {
					mArray[j + 1] = mArray[j];
					j--;
				}
				mArray[j + 1] = temp;
			}
		}
		return mArray;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0;

		while (true) {
			System.out.println("1. push()");
			System.out.println("2. pop()");
			System.out.println("3. SortStake()");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					mArray = push(mArray, data);
					System.out.println("after push()");
					DisplayStake(mArray);

					break;

				} case 2: {
					mArray = pop(mArray);
					DisplayStake(mArray);

					break;					
				} case 3: {
					mArray = SortStack(mArray);
					System.out.println("After sorting..");
					DisplayStake(mArray);

					break;
				}
			}
		}
	}
}