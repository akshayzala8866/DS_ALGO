import java.util.*;

public class BellmanFord_SortestPath {
	int V, E;

	public class Edge {
		int src, des, weight;
		Edge() {
			src = des = weight = 0;
		}
	}

	Edge edge[];

	BellmanFord_SortestPath(int v, int e) {
		V = v;
		E = e;

		edge = new Edge[e];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge();
		}
	}

	public static void PrintMinDistance(int distance[], int v) {
		for (int i = 0; i < v; i++) {
			System.out.println(i + " -> " + distance[i]);
		}
	}

	public static void BellmanFord(BellmanFord_SortestPath graph) {
		int V = graph.V;
		int E = graph.E;

		int u = 0, v = 0, weight = 0;

		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[0] = 0;

		// relaxing for |v| - 1 time..
		for (int i = 1; i < V; i++) {
			for (int j = 0; j < E; j++) {
				u = graph.edge[j].src;
				v = graph.edge[j].des;
				weight = graph.edge[j].weight;
				if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
					distance[v] = distance[u] + weight;
				}
			}
		}

		// one more time relaxation..
		for (int i = 0; i < E; i++) {
			u = graph.edge[i].src;
			v = graph.edge[i].des;
			weight = graph.edge[i].weight;
			if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
				System.out.println("there is negative weighted cycle..!!");
				return;
			}
		}

		PrintMinDistance(distance, V);
	}

	public static void main(String[] args) {
		int V = 4;
		int E = 4;

		BellmanFord_SortestPath graph = new BellmanFord_SortestPath(V, E);

		graph.edge[0].src = 0;
		graph.edge[0].des = 1;
		graph.edge[0].weight = 4;

		graph.edge[1].src = 0;
		graph.edge[1].des = 3;
		graph.edge[1].weight = 5;

		// graph.edge[2].src = 2;
		// graph.edge[2].des = 1;
		// graph.edge[2].weight = -10;

		graph.edge[2].src = 3;
		graph.edge[2].des = 2;
		graph.edge[2].weight = 3;

		graph.edge[3].src = 1;
		graph.edge[3].des = 3;
		graph.edge[3].weight = 5;

		BellmanFord(graph);

	}
}