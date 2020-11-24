public class Travelling_Salesmen_Problem {

	public static int TSP(int mArray[][], int visited[], int start, int n, int count, int cost, int ans) {
		System.out.println("current pointer : " + start);
		// for (int i : visited) {
		// 	System.out.print(i + " ");
		// }
		// System.out.println("");
		System.out.println(" ans : " + ans);				

		if (count == n && mArray[start][0] > 0) {
			ans = Math.min(ans, cost + mArray[start][0]);
			return ans;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0 && mArray[start][i] > 0) {
				visited[i] = 1;
				ans = TSP(mArray, visited, i, n, count + 1, cost + mArray[start][i], ans);
				visited[i] = 0;
			}
		}

		return ans;
	
}
	public static void main(String[] args) {
		int n = 4;
		int visited[] = new int[n];
		int mArray[][] = { {0, 10, 15, 20}, 
                           {10, 0, 35, 25}, 
                           {15, 35, 0, 30}, 
                           {20, 25, 30, 0} }; 

        visited[0] = 1;
        int ans = Integer.MAX_VALUE;
        ans = TSP(mArray, visited, 0, n, 1, 0, ans);
        System.out.println(ans);
	}
}