import java.util.*;

public class Subset_sum_DP {

	// recursive approach.
	public static boolean sum_find(int subset[], int sum, int length) {
		if (sum == 0) {
			return true;
		}
		if (length < 0 && sum != 0) {
			return false;
		}

		if (subset[length] > sum) {
			return sum_find(subset, sum, length - 1);
		}

		return sum_find(subset, sum - subset[length], length - 1) || sum_find(subset, sum, length - 1);
	}

	public static void printTable(boolean table[][]) {
		for (int i = 0; i < table.length; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j]) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
	}

	public static boolean sum_find1(int subset[], int sum, int n) {
		boolean table[][] = new boolean[n + 1][sum + 1];
		//if sum is '0' then true
		for (int i = 0; i < n; i++) {
			table[i][0] = true;
		}

		//if set is '0' then false
		for (int i = 1; i <= sum; i++) {
			table[0][i] = false;
		}

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table[0].length; j++) {
				table[i][j] = table[i - 1][j];
				if (subset[i - 1] <= j) {
					table[i][j] = table[i][j] || table[i - 1][j - subset[i - 1]];
				}
			}
		}

		printTable(table);

		return table[n][sum];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int subset[] = new int[n];

		for (int i = 0; i < n; i++) {
			subset[i] = s.nextInt();
		}

		int sum = s.nextInt();

		if (sum_find1(subset, sum, n)) {
			System.out.println("Sum Founded");
		} else {
			System.out.println("Sum not Founded");
		}
	}
}