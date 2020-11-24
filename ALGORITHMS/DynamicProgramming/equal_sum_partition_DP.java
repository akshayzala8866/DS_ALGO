import java.util.*;

public class equal_sum_partition_DP {

	public static boolean isPartitionPossible(int set[], int sum, int length) {
		boolean table[][] = new boolean[length + 1][sum + 1];
		for (int i = 0; i <= length; i++) {
			table[i][0] = true;
		}
		for (int i = 1; i <= sum; i++) {
			table[0][i] = false;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				table[i][j] = table[i - 1][j];
				if (set[i - 1] <= j) {
					table[i][j] = table[i][j] || table[i - 1][j - set[i - 1]];
				}
			}
		}

		return table[length][sum];
	}

	public static boolean equal_sum_possible(int set[]) {
		int sum = 0;
		for (int i : set) {
			sum += i;
		}

		if (sum % 2 != 0) {
			return false;
		}

		return isPartitionPossible(set, sum / 2, set.length);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int set[] = new int[n];
		for (int i = 0; i < n; i++) {
			set[i] = s.nextInt();
		}

		if (equal_sum_possible(set)) {
			System.out.println("Possible");
		} else {
			System.out.println("Not Possible");
		}
	}
}