import java.util.Scanner;

public class Graph_Adjacency_Matrix {

	public boolean mArray[][];
	public int size = 0;

	public Graph_Adjacency_Matrix(int size) {
		this.size = size;
		mArray = new boolean[size][size];		
	}

	public void AddNode(int node1,int node2) {
		mArray[node1 - 1][node2 - 1] = true;
		mArray[node2 - 1][node1 - 1] = true;
	}

	public void DisplayGraph() {
		for (int i = 0; i< mArray.length; i++) {
			for (boolean j : mArray[i]) {
				if (j == true) {
					System.out.print(1 + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
	}

	public void DeleteNode(int node1, int node2) {
		mArray[node1 - 1][node2 - 1] = false;
		mArray[node2 - 1][node1 - 1] = false;		
	}

	public static void main(String[] args) {
		Graph_Adjacency_Matrix obj = new Graph_Adjacency_Matrix(5);
		Scanner s = new Scanner(System.in);
		int node1 = 0, node2 = 0, ch = 0;

		while (true) {

			System.out.println("1. Add Egde");
			System.out.println("2. Remove Egde");

			System.out.println("Enter choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					node1 = s.nextInt();
					node2 = s.nextInt();
					
					obj.AddNode(node1, node2);
					obj.DisplayGraph();
					
					break;		
				} case 2: {
					System.out.println("Enter data : ");
					node1 = s.nextInt();
					node2 = s.nextInt();
					
					obj.DeleteNode(node1, node2);
					obj.DisplayGraph();
					
					break;
				}
			}
		}
	}
}