import java.util.*;

public class Euqal_sum_set_of_array_DP {

	public static ArrayList<Integer> set1 = new ArrayList<>();
	public static ArrayList<Integer> set2 = new ArrayList<>();

	public static boolean findSets(int set[], int length, int sum) {
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

		if (!table[length][sum]) {
			return false;
		}

		int i = length, c_sum = sum;

		while (i > 0 && c_sum >= 0) {
			if (table[i - 1][c_sum]) {
				i--;
				set2.add(set[i]);
			} else if (table[i - 1][c_sum - set[i - 1]]) {
				i--;
				c_sum = c_sum - set[i];
				set1.add(set[i]);
			}
		}

		return true;
	}

	public static boolean isSetPossible(int set[], int length) {
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += set[i];
		}

		if (sum % 2 != 0) {
			return false;
		}

		return findSets(set, length, sum / 2);
	}

	public static void printSets() {
		for (int i : set1) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (int i : set2) {
			System.out.print( i + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int set[] = new int[n];
		for (int i = 0; i < n; i++) {
			set[i] = s.nextInt();
		}

		if (isSetPossible(set, set.length) == false) {
			System.out.println(":(");
		} else {
			printSets();
			System.out.println(":)");
		}
	}
}