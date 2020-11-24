import java.util.*;

public class Practice_DP {

	public static int getMax(int mArray[]) {
		int max = mArray[0];
		for (int i = 1; i < mArray.length; i++) {
			if (mArray[i] > max) {
				max = mArray[i];
			}
		}

		return max;
	}

	public static void find_count(int count[], int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			++count[mArray[i]];
		}

		for (int i : count) {
			System.out.print(i + " ");
		}
	}

	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			mArray[i] = s.nextInt();
		}

		int max = getMax(mArray);

		int count[] = new int[max + 1];

		find_count(count, mArray);
	}
}	
