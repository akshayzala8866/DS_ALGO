public class SudokuSolver {

	public static int n = 4;
	public static int mArray[][] = {{1, 0, 2, 4},{0, 0, 3, 1}, {3, 4, 0, 2}, {0, 0, 4, 0}};

	public static boolean isRowCheck(int board[][], int row, int num) {
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == num) {
				return false;
			}
		}
		return true;
	}

	public static boolean isColCheck(int board[][], int col, int num) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}

		return true;
	}

	public static boolean isBoxCheck(int board[][], int row, int col, int num) {
		int rowStart = row - row % 2;
		int colStart = col - col % 2; 

		for (int i = rowStart; i < rowStart + 2; i++) {
			for (int j = colStart; j < colStart + 2; j++) {
				if (board[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean canPutNum(int board[][], int row, int col, int num) {
		if (!isRowCheck(board, row, num)) {
			return false;
		}

		if (!isColCheck(board, col, num)) {
			return false; 
		}

		if (!isBoxCheck(board, row, col, num)) {
			return false;
		}

		return true;
	}

	public static boolean isSolved(int mArray[][]) {
		int row = -1;
		int col = -1;
		boolean isEmpty = false;

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray.length; j++) {
				if (mArray[i][j] == 0) {
					isEmpty = true;
					row = i;
					col = j;
					break;
				}
			}
			if (isEmpty) {
				break;
			}
		}
		
		if (!isEmpty) {
			return true;
		}

		for (int num = 1; num <= mArray.length; num++) {
			if (canPutNum(mArray, row, col, num)) {
				mArray[row][col] = num;
				if (isSolved(mArray)) {
					return true;
				}
				mArray[row][col]  = 0;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSolvejd(mArray));

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray.length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");

	}
}