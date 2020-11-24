import java.util.*;

public class min_coins_to_make_given_value {

	public static int find_min_coins2(int coins[], int V) {
		int visited[] = new int[V + 1];

		Arrays.fill(visited, Integer.MAX_VALUE);

		visited[0] = 0;

		for (int i = 1; i <= V; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int sub_result = visited[i - coins[j]];
					if (sub_result != Integer.MAX_VALUE && sub_result + 1 < visited[i]) {
						visited[i] = sub_result + 1;
					}
				}	
			}
		}

		return visited[V];
	}

	public static int find_min_coins(int coins[], int V) {
		if (V == 0) {
			return 0;
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= V) {
				int sub_result = find_min_coins(coins, V - coins[i]);

				if (sub_result != Integer.MAX_VALUE && sub_result + 1 < result) {
					result = sub_result + 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int coins[] = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = s.nextInt();
		}
		int V = s.nextInt();

		System.out.println("Answer 1: " + find_min_coins(coins, V));
		System.out.println("Answer 2: " + find_min_coins2(coins, V));
	}
}