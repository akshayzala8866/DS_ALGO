import java.util.*;

public class Max_Average_Sum_Partition {

	public static double table[][];

	public static double find_Max_Avg(int mArray[], int n, int partition) {
		if (table[n][partition] > 0) {
			return table[n][partition];
		}

		double sum = 0;

		// bottom approach..
		for (int i = n - 1; i > 0; i--) {
			sum += mArray[i];
			table[n][partition] = Math.max(table[n][partition], find_Max_Avg(mArray, i, partition - 1) + (sum / (n - i)));
		} 

		return table[n][partition];
	}

	public static double max_Avg_sum(int mArray[], int n, int partition) {
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mArray[i]; 
			// storing avg from starting to ith element
			table[i + 1][1] = sum / (i + 1);
		}

		return find_Max_Avg(mArray, n, partition);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int mArray[] = new int[n];
		for (int i = 0; i < n; i++) {
			mArray[i] = s.nextInt();
		}

		int partition = s.nextInt();
		table = new double[n + 1][partition + 1];

		System.out.println(max_Avg_sum(mArray, n, partition));
	}
}