import java.util.*;

public class Nuts_Bolts_QuickSort {

	public static void PrintValues(char nuts[], char bolts[]) {
		for (char i : nuts) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (char i : bolts) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static int Partition(char mArray[], int lb, int ub, char pivote) {
		int start = lb, end = ub;
		char temp;
		while (start < end) {
			while (mArray[start] <= pivote && start < ub) {
				start++;
			}
			while (mArray[end] > pivote && end > lb) {
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

	public static void Divide(char nuts[], char bolts[], int lb, int ub) {
		if (lb < ub) {
			int index = Partition(nuts, lb, ub, bolts[lb]);
			Partition(bolts, lb, ub, nuts[index]);

			Divide(nuts, bolts, lb, index - 1);
			Divide(nuts, bolts, index + 1, ub);
		}
	}

	public static void main(String[] args) {
		char nuts[] = {'@', '#', '$', '%', '^', '&'}; 
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        Divide(nuts, bolts, 0, nuts.length - 1);

        PrintValues(nuts, bolts);
	}
}