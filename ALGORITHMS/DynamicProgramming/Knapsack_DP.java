import java.util.*;

public class Knapsack_DP {

	public static void knapsack(int value[], int weight[], int W, int n) {
		int k_table[][]= new int[n + 1][W + 1];

		for (int i = 0; i < k_table.length; i++) {
			for (int j = 0; j < k_table[0].length; j++) {
				if (i == 0 || j == 0) {
					k_table[i][j] = 0;
				} else if (weight[i - 1] <= j) {
					k_table[i][j] = Math.max(k_table[i - 1][j], value[i - 1] + k_table[i - 1][j - weight[i - 1]]);
				} else {
					k_table[i][j] = k_table[i - 1][j];
				}
			}
		}
		PrintTable(k_table);

		int profit = k_table[n][W];
		int new_weight = W;
		for (int i = n; i > 0 && profit > 0; i--) {
			if (k_table[i - 1][new_weight] == profit) {
				continue;
			} else {
				System.out.print(weight[i - 1] + " ");

				new_weight -= weight[i - 1];
				profit -= value[i - 1];
			}
		}
	}

	public static void PrintTable(int k_table[][]) {
		for (int i = 0; i < k_table.length; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < k_table[0].length; j++) {
				System.out.print(k_table[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		int v, w;
		int value[], weight[];

		v = s.nextInt();
		value = new int[v];

		for (int i = 0; i < v; i++) {
			value[i] = s.nextInt();
		}

		w = s.nextInt();
		weight = new int[w];

		for (int i = 0; i < w; i++) {
			weight[i] = s.nextInt();
		}

		int W = s.nextInt();

		knapsack(value, weight, W, v);
	}
}