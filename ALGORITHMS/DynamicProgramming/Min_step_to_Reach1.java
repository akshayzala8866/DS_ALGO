import java.util.*;

public class Min_step_to_Reach1 {

	// recursive soulution
	public static int min_step(int n) {
		if (n == 1) {
			return 0;
		}
		int ans = min_step(n - 1) + 1;
		
		if (n % 2 == 0) {
			ans = Math.min(ans, min_step(n/2) + 1);
		}

		if (n % 3 == 0) {
			ans = Math.min(ans, min_step(n/3) + 1);
		}

		return ans;
	}

	// stroing result into array... (top down approach)
	public static int min_step2(int n, int visited[]) {
		if (n == 1) {
			return 0;
		}

		if (visited[n] > 0) {
			return visited[n];
		}

		int ans = 1 + min_step2(n - 1, visited);

		if (n % 2 == 0) {
			ans = Math.min(ans, min_step2(n / 2, visited) + 1);
		}

		if (n % 3 == 0) {
			ans = Math.min(ans, min_step2(n / 3, visited) + 1);
		}

		visited[n] = ans;
		return ans;
	}

	// using arrray we sotre min answer using bottom approach..
	public static int min_step3(int n) {
		int visited[] = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int ans = 1 + visited[i - 1];

			if (i % 2 == 0) {
				ans = Math.min(ans, 1 + visited[i / 2]);
			}

			if (i % 3 == 0) {
				ans = Math.min(ans, 1 + visited[i / 3]);
			}
			visited[i] = ans;
		}	
		return visited[n];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int visited[] = new int[n + 1];

		System.out.println(min_step(n));
		System.out.println(min_step2(n, visited));
		System.out.println(min_step3(n));
	}
}