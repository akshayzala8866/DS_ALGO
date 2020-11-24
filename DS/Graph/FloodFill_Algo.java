public class FloodFill_Algo {
	public static int n = 4;
	public static int mArray[][] = {{0, 0, 0, 0}, 
								{0, 1, 1, 0},
								{0, 1, 1, 0},
								{1, 1, 1, 1}};

	public static void floodFill(int mArray[][], int x, int y, int newC) {
		int prevC = mArray[x][y];
		floodFillUtil(mArray, x, y, newC, prevC);
	}

	public static void floodFillUtil(int mArray[][], int x, int y, int newC, int prevC) {
		if (x < 0 || y < 0 || x >= n || y >= n) {
			return;
		}

		if (mArray[x][y] != prevC) {
			return;
		}

		mArray[x][y] = newC;

		// move right..
		floodFillUtil(mArray, x + 1, y, newC, prevC);
		// move left
		floodFillUtil(mArray, x - 1, y, newC, prevC);
		// move top
		floodFillUtil(mArray, x, y - 1, newC, prevC);
		// move bollom
		floodFillUtil(mArray, x, y + 1, newC, prevC);
	}

	public static void PrintScreen(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int x = 1, y = 1, newC = 4;
		floodFill(mArray, x, y, newC);

		System.out.println("Updated screen");
		PrintScreen(mArray);
	}
}