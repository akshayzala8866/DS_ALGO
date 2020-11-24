import java.util.*;

public class Flyod_warshall_All_pair {
	public static int n = 4;
	public static int INF = 99999; 
	public static int mArray[][] = new int[n][n];

	public static void Add_node(int a, int b, int weight) {
		mArray[a][b] = weight;
	}

	public static void ManageGraph(int mArray[][]) {

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				if (mArray[i][j] == 0 && (i != j)) {
					mArray[i][j] = INF;
				}
			}
		}
	}

	public static void printAnswer(int minDistance[][]) {

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				if (mArray[i][j] == INF) {
					System.out.print("INF" + "\t");
				} else {
					System.out.print(mArray[i][j] + "\t");
				}
			}
			System.out.println("");
		}

	}

	public static void FlyodWarshallAlgo(int mArray[][]) {
		int minDistance[][] = new int[n][n];

		minDistance = Arrays.copyOf(mArray, mArray.length);

		// for kth node as intermediate node..
		for (int k = 0; k < n; k++) {
			// consider every vertex as source node..
			for (int i = 0; i < n; i++) {
				// consider jth node as destination node for ith vertex..
				for (int j = 0; j < n; j++) {
					if (minDistance[i][k] + minDistance[k][j] < minDistance[i][j]) {
						minDistance[i][j] = minDistance[i][k] + minDistance[k][j];
					}
				}
			}
		}
		printAnswer(minDistance);
	}

	public static void main(String[] args) {
		Add_node(0, 1, 3);
		Add_node(0, 3, 7);
		Add_node(1, 0, 8);
		Add_node(1, 2, 2);
		Add_node(2, 3, 1);
		Add_node(2, 0, 5);
		Add_node(3, 0, 2);

		ManageGraph(mArray);

		FlyodWarshallAlgo(mArray);
	}
}