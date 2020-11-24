public class Print_Path_Top_To_Right {

	public static void FindPath(int mArray[][], int path[], int x, int y, int pos) {
		path[pos] = mArray[x][y];

		// reach to last row
		if (x == mArray.length - 1) {
			for (int k = y + 1; k < mArray[0].length; k++) {
				path[pos + k - y] = mArray[x][k];
			}
			for (int a : path) {
				System.out.print(a + " ");
			}
			System.out.println("");
			return;
		}

		// reach to last collumn
		if (y == mArray[0].length - 1) {
			for (int k = x + 1; k < mArray.length; k++) {
				path[pos + k - x] = mArray[k][y];
			}
			for (int a : path) {
				System.out.print(a + " ");
			}
			System.out.println("");
			return;
		}

		// down
		FindPath(mArray, path, x + 1, y, pos + 1);

		// right
		FindPath(mArray, path, x, y + 1, pos + 1);
	}

	public static void main(String[] args) {
		int mArray[][] = {{1, 2, 3}, {4, 5, 6}};
		int MaxPathLength = mArray.length + mArray[0].length - 1;
		int path[] = new int[MaxPathLength];
		FindPath(mArray, path, 0, 0, 0);
	}
}