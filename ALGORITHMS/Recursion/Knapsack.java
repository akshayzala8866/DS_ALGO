public class Knapsack {

	public static int Max_val(int a, int b) {
		return (a > b) ? a : b;
	}

	// public static int Knapsack(int val[], int wt[], int W, int n) {
	// 	if (n == -1 || W == 0) {
	// 		return 0;
	// 	}

	// 	if (wt[n] > W) {
	// 		return Knapsack(val, wt, W, n - 1);
	// 	} else {
	// 		return Max_val(val[n] + Knapsack(val, wt, W - wt[n], n - 1), Knapsack(val, wt, W, n - 1));
	// 	}
	// }

	public static void Knapsack(int val[], int wt[], int W, int n) {
		int k[][] = new int[n + 1][W + 1];

		for (int i = 0; i < k.length; i++) {
			for (int j = 0; j < k[0].length; j++) {
				if (i == 0 || j == 0) {
					k[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					k[i][j] = Math.max(k[i - 1][j], val[i - 1] + k[i - 1][j - wt[i - 1]]);
				} else {
					k[i][j] = k[i - 1][j];
				}
			}
		}

		PrintArray(k);

		int profit = k[n][W];
		int weight = W;

		for (int i = n; i > 0 && profit > 0; i--) {
			if (profit == k[i - 1][weight]) {
				continue;
			} else {
				System.out.print(wt[i - 1] + " ");

				profit = profit - val[i - 1];
				weight = weight - wt[i - 1];
			}
		}
	}	

	public static void PrintArray(int k[][]) {
		for (int i = 0; i < k.length; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < k[0].length; j++) {
				System.out.print(k[i][j] + ", ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int val[] = {2, 3, 4, 1};
		int wt[] = {3, 4, 5, 6}; // must be in assending order...!!
		int W = 8;
		// System.out.println(Knapsack(val, wt, W, val.length - 1));
		Knapsack(val, wt, W, val.length);
	}
}