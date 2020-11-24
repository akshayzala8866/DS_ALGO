import java.util.*;

public class Snack_Ladder_Probelm {
	public static int n = 30;

	static class QueueEntry {
		int v; // vertex number;
		int dist; // distance from this vertex to source vertex.
	}

	public static int SnackAndladder(int moves[], int n) {
		int visited[] = new int[n];
		Queue<QueueEntry> q = new LinkedList<>();
		QueueEntry q_entry = new QueueEntry();
		q_entry.v = 0;
		q_entry.dist = 0;

		visited[0] = 1;
		q.add(q_entry);

		while (!q.isEmpty()) {
			q_entry = q.remove();
			int v = q_entry.v;

			if (v == n - 1) {
				break;
			}

			for (int i = v + 1; i <= (v + 6) && i < n; i++) {
				if (visited[i] == 0) {
					QueueEntry a = new QueueEntry();
					a.dist = (q_entry.dist + 1);
					visited[i] = 1;

					if (moves[i] != -1) {
						a.v = moves[i];
					} else {
						a.v = i;
					}
					q.add(a);
				}
			}
		}

		return q_entry.dist;
	} 

	public static void main(String[] args) {
		int moves[] = new int[n];
		Arrays.fill(moves, -1);

		//ladders
		moves[2] = 21;
		moves[4] = 8;
		moves[10] = 25;
		moves[19] = 28;

		// snacks
		moves[16] = 3;
		moves[18] = 6;
		moves[20] = 8;
		moves[26] = 0;

		System.out.println("Minimum answer is : " + SnackAndladder(moves, n));
	}
}