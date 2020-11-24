import java.util.*;

public class Fibonacci_DP {

	public static int fib1(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib1(n - 1) + fib1(n - 2);
	}

	public static int fib2(int n, int visited[]) {
		if (n == 1 || n == 0) {
			return n;
		}
		if (visited[n] > 0) {
			return visited[n];
		}
		int output = fib2(n - 1, visited) + fib2(n - 2, visited);
		visited[n] = output;
		return output;
	}

	public static int fib3(int n) {
		int visited[] = new int[n];
		visited[0] = 1;
		visited[1] = 1;

		for (int i = 2; i < n; i++) {
			visited[i] = visited[i - 1] + visited[i - 2];
		}
		return visited[n - 1];
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int visited[] = new int[n + 1];

		System.out.println(fib1(n));
		System.out.println(fib2(n, visited));
		System.out.println(fib3(n));
	}
}