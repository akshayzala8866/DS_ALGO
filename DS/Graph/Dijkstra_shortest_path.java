import java.util.*;

public class Dijkstra_shortest_path {
	public static int n = 4; 
	public static int mArray[][] = new int[n][n];

	public static void PrintGraph() {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void Add_Node(int a, int b, int weight) {
		mArray[a][b] = weight;
		mArray[b][a] = weight;
 	}

 	public static int FindMinIdex(int visited[], int distance[]) {
 		int min_distance = Integer.MAX_VALUE, min_index = -1;

 		for (int v = 0; v < n; v++) {
 			if (visited[v] == 0 && distance[v] < min_distance) {
 				min_distance = distance[v];
 				min_index = v;
 			}
  		}
  		return min_index;
 	}

 	public static void printDistance(int distance[]) {
 		System.out.println("");
 		for (int i : distance) {
 			System.out.print(i + " ");
 		}
 		System.out.println("");
 	}

 	public static void Dijkstra(int source, int visited[], int distance[]) {
 		
 		for (int i = 0; i < n; i++) {
 			int current_node = FindMinIdex(visited, distance);

 			visited[current_node] = 1;

 			for (int v = 0; v < n; v++) {
 				if (visited[v] == 0 && mArray[current_node][v] != 0 && distance[current_node] != Integer.MAX_VALUE && distance[current_node] + mArray[current_node][v] < distance[v]) {
 					distance[v] = distance[current_node] + mArray[current_node][v];
 				}
 			}
 		}

 		printDistance(distance);
 	}

	public static void main(String[] args) {
		Add_Node(0, 1, 4);
		Add_Node(0, 2, 6);
		Add_Node(1, 2, 8);
		Add_Node(2, 3, 10);

		PrintGraph();

		int visited[] = new int[n];
 		int distance[] = new int[n];

 		Arrays.fill(visited, 0);
 		Arrays.fill(distance, Integer.MAX_VALUE);

		int source = 0;
		distance[source] = 0;

		Dijkstra(source, visited, distance);
	}
}