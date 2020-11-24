import java.util.*;

public class Graph_Adjacency_List {

	public void AddNode(ArrayList< ArrayList<Integer> > adj, int node1, int node2) {
		adj.get(node1).add(node2);
		adj.get(node2).add(node1);
	}

	public void RemoveNode(ArrayList< ArrayList<Integer> > adj, int node1, int node2) {
		for (int i = 0; i < adj.get(node1).size(); i++) {
			if (adj.get(node1).get(i) == node2) {
				adj.get(node1).remove(i);
			}
		}

		for (int i = 0; i < adj.get(node2).size(); i++) {
			if (adj.get(node2).get(i) == node1) {
				adj.get(node2).remove(i);
			}
		}
	}

	public void DisplayGraph(ArrayList< ArrayList<Integer> > adj) {
		System.out.println("Adjacency List : ");

		for (int i = 0; i < adj.size(); i++) {
			System.out.print(i + " : ");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + ", ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		Graph_Adjacency_List obj = new Graph_Adjacency_List();
		Scanner s  = new Scanner(System.in);
		int V = 5;

		ArrayList< ArrayList<Integer> > adj = new ArrayList< ArrayList<Integer> >(V);
		int ch = 0, node1 = 0, node2 = 0;

		for (int i = 0; i< V; i++) {
			adj.add(new ArrayList<Integer>());
		}
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

					obj.AddNode(adj, node1, node2);	
					obj.DisplayGraph(adj);
		
					break;		
				} case 2: {
					System.out.println("Enter data : ");
					node1 = s.nextInt();
					node2 = s.nextInt();

					obj.RemoveNode(adj, node1, node2);
					obj.DisplayGraph(adj);

					break;
				}
			}
		}
	}
}