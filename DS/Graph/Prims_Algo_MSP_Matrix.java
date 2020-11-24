import java.util.*;

public class Prims_Algo_MSP_Matrix {

	public static int n =4;
	public static int mArray[][] = new int[n][n];

	public static void Add_Node(int a, int b, int weight) {
		mArray[a][b] = weight;
		mArray[b][a] = weight;
	}

	public static void PrintGraph() {
		System.out.println("");
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
	} 

    public static int minWeight(int visited[], int distance[]) {
    	int min = Integer.MAX_VALUE, min_index = -1;

    	for (int i = 0; i < n; i++) {
    		if (visited[i] == 0 && distance[i] < min) {
    			min = distance[i];
    			min_index = i;
    		} 
    	}
    	
    	return min_index;
    }

    public static void PrintMST(int MST[]) {
        for (int i = 1; i < n; i++) {
            System.out.println(MST[i] + "-" + i + " -> " + mArray[MST[i]][i]);
        }
    }

    public static void Prims_MST(int visited[], int distance[]) {
    	int MST[] = new int[n];
    	MST[0] = -1; // first node is always root node..

    	for (int i = 0; i < n; i++) {
    		int parent_node = minWeight(visited, distance);

    		visited[parent_node] = 1;

    		for (int v = 0; v < n; v++) {
    			if (visited[v] == 0 && mArray[parent_node][v] != 0 && mArray[parent_node][v] < distance[v]) {
    				distance[v] = mArray[parent_node][v];
    				MST[v] = parent_node;
    			}
    		}
    	}

    	PrintMST(MST);
    }

	public static void main(String[] args) {
		int visited[] = new int[n];
		int distance[] = new int[n];
		
		Add_Node(0, 1, 4);
		Add_Node(0, 2, 6);
		Add_Node(1, 2, 8);
		Add_Node(2, 3, 10);

		PrintGraph();

		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[0] = 0;

		Prims_MST(visited, distance);
	}
}