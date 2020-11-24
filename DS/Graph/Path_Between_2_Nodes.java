import java.util.*;

public class Path_Between_2_Nodes {
	public static int n = 4;
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static int mArray[][] = new int[n][n];

	public static void Add_Node(int n1, int n2) {
		if (n1 < mArray.length && n2 < mArray.length) {
			mArray[n1][n2] = 1;
			mArray[n2][n1] = 1;
		} else {
			System.out.println("try again :(");
		}
	}

	public static void PrintGraph(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static boolean BFS(int visited[], int start, int dest) {
		visited[start] = 1;
		q.add(start);

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == dest) {
				return true;
			} 
			for (int i = 0; i < n; i++) {
				if (mArray[start][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int visited[] = new int[n];
		Add_Node(0, 1);
		Add_Node(1, 2);
		Add_Node(2, 3);
		Add_Node(3, 0);

		int start = 0, dest = 0;
		PrintGraph(mArray);
		if (BFS(visited, start, dest)) {
			System.out.println("Path is fount b/w " + start + " to "+ dest);
		} else {
			System.out.println("Path is not-fount b/w " + start + " to "+ dest);
		}
	}
}