public class Rate_In_Maze {

	static int n = 3; 
	static int mArray[][] = { {1, 1, 0}, {1, 1, 0}, {1, 1, 1} };
	static int path[][] = new int[n][n];
	static int count = 0;

	public static void find_Path(int mArray[][], int n, int x, int y, int path[][]) {
		if (x < 0 || x >= n || y < 0 || y >= n) {
			return;
		}

		if (mArray[x][y] == 0 || path[x][y] == 1) {
			return;
		}

		path[x][y] = 1;
		
		if (x == n - 1 && y == n - 1) {
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(path[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("");

			path[x][y] = 0;
			count++;
			return;
		}

		// right
		find_Path(mArray, n, x, y + 1, path);
		// left
		find_Path(mArray, n, x, y - 1, path);
		// top
		find_Path(mArray, n, x - 1, y, path);
		//down
		find_Path(mArray, n, x + 1, y, path);

		path[x][y] = 0;
	}

	public static void main(String[] args) {
		find_Path(mArray, n, 0, 0, path);

		System.out.println("count : " + count);
	}
}