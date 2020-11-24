import java.util.*;

public class Coin_change {

	// recursive solution..
	public static int find_solution(int rs, int changes[], int length) {
		if (rs == 0) {
			return 1;
		}

		if (rs < 0) {
			return 0;
		}

		if (length < 0) {
			return 0;
		}

		int option1 = find_solution(rs - changes[length], changes, length);
		int option2 = find_solution(rs, changes, length - 1);

		return option1 + option2;
	}

	//DP solution
	public static int find_solution1(int rs, int changes[], int length, int visited[][]) {
	
		if (rs == 0) {
			return 1;
		}

		if (rs < 0 || length < 0) {
			return 0;
		}

		if (visited[rs - 1][length] >= 0) {
			return visited[rs - 1][length];
		}

		int option1 = find_solution1(rs - changes[length], changes, length, visited);
		int option2 = find_solution1(rs, changes, length - 1, visited);

		visited[rs - 1][length] = option1 + option2;

		return option1 + option2;
	}
 
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		int rs = s.nextInt();
		int c = s.nextInt();
		int changes[] = new int[c];
		int visited[][] = new int[rs][c];

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = -1;
			}
		}

		for (int i = 0; i < c; i++) {
			changes[i] = s.nextInt();
		}

		System.out.println("ans 1 : " + find_solution(rs, changes, c - 1));
		System.out.println("ans 2 : " + find_solution1(rs, changes, c - 1, visited));
	}
}