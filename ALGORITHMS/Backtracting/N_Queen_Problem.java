public class N_Queen_Problem {

	public static int n = 4;
	public static int mArray[][] = { {0, 0, 0, 0}, 
									 {0, 0, 0, 0}, 
									 {0, 0, 0, 0},
									 {0, 0, 0, 0} };

	public static void PrintBoard(int mArray[][]) {
		System.out.println("");
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray.length; j++) {
				System.out.print(mArray[i][j] + ", ");
			}
			System.out.println("");
		}
	}								 

	public static boolean isQueenPlaced(int mArray[][], int row, int col) {
		int i = 0, j = 0;

		System.out.println("row : " + row + " col : " + col);
		// row clash
		for (i = 0; i < mArray.length; i++) {
			if (mArray[row][i] == 1) {
				return false;
			}
		}

		// upper left diagonal
		for (i = row, j = col; i >= 0 && j >=0; i--, j--) {
			if (mArray[i][j] == 1) {
				return false;	
			}
		}

		// lower left diagonal
		for (i = row, j = col; i < n && j >= 0; i++, j--) {
			if (mArray[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public static boolean NQueen(int mArray[][], int col) {
		if (col >= n) {
			PrintBoard(mArray);
		}

		for (int i = 0; i < mArray.length; i++) {
			if (isQueenPlaced(mArray, i, col)) {
				mArray[i][col] = 1;
				if (NQueen(mArray, col + 1)) {
					return true;
				}
				mArray[i][col] = 0;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		if (NQueen(mArray, 0)) {
			PrintBoard(mArray);
		}
	}
}