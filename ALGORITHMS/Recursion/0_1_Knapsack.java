public class 0_1_Knapsack {

	public static int Max_val(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int Knapsack(int val[], int wt[], int W, int n) {
		if (n == -1 || W == 0) {
			return 0;
		} 

		return Max_val(val[n] + Knapsack(val, wt, W - wt[n], n - 1), Knapsack(val, wt, W, n - 1));
	}

	public static void main(String[] args) {
		int val[] = {1, 2, 3};
		int wt[] = {4, 5, 1};
		int W = 4;
		System.out.println(Knapsack(val, wt, W, val.length - 1));
	}
}