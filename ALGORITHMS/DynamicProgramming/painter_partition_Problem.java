import java.util.*;

public class painter_partition_Problem {

	// recursive approach
	public static int find_sum(int paints[], int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i++) {
			sum += paints[i];
		}

		return sum;
	}

	public static int min_time(int paints[], int painter, int n) {
		if (painter == 1) {
			return find_sum(paints, 0, n - 1);
		}
		if (n == 0) {
			return paints[0];
		}

		int result = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			result = Math.min(result, Math.max(min_time(paints, painter - 1, i), find_sum(paints, i, n - 1)));
		}

		return result;
	}

	// DP approach
	public static int getMax(int paints[], int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (paints[i] > max) {
				max = paints[i];
			}
		}

		return max;
	}

	public static int getSum(int paints[], int n) {
		int sum = 0; 
		for (int i = 0; i < n; i++) {
			sum += paints[i];
		}

		return sum;
	}

	public static int getPainters(int paints[], int n, int maxLimit) {
		int total = 0, mPainters = 1;
		for (int i = 0; i < n; i++) {
			total += paints[i];

			if (total > maxLimit) {
				total = paints[i];
				mPainters++;
			}
		}

		return mPainters;
	}

	public static int min_time_DP(int paints[], int painters, int n) {
		int lo = getMax(paints, n);
		int hi = getSum(paints, n);

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int requiredPainters = getPainters(paints, n, mid);

			if (requiredPainters <= painters) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int paints[] = new int[n];
		for (int i = 0; i < n; i++) {
			paints[i] = s.nextInt();
		}
		int painter = s.nextInt();

		// System.out.println(min_time(paints, painter, n));
		System.out.println(min_time_DP(paints, painter, n));
	}
}