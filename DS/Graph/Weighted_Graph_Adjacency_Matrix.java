import java.util.*;

public class Weighted_Graph_Adjacency_Matrix {

	public int mArray[][];
	public int size = 0;

	public Weighted_Graph_Adjacency_Matrix(int size) {
		this.size = size;
		mArray = new int[size][size];
	}

	public void AddNode(int node1, int node2, int weight) {
		mArray[node1 - 1][node2 - 1] = weight;
		mArray[node2 - 1][node1 - 1] = weight;
	}

	public void DisplayGraph() {
		for (int i = 0; i < mArray.length; i++) {
			for (int j : mArray[i]) {
				System.out.print(j + ", ");			
			}
			System.out.println("");
		}
	}

	public void DeleteNode(int node1, int node2) {
		mArray[node1 - 1][node2 - 1] = 0;
		mArray[node2 - 1][node1 - 1] = 0;
	}

	public static void main(String[] args) {
		Weighted_Graph_Adjacency_Matrix obj = new Weighted_Graph_Adjacency_Matrix(5);
		Scanner s = new Scanner(System.in);
		int node2 = 0, node1 = 0, weight = 0, ch = 0;

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
					System.out.println("Enter weight : ");
					weight = s.nextInt();

					obj.AddNode(node1, node2, weight);
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