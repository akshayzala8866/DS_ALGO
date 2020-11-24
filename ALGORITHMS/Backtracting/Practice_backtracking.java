import java.util.*;

public class Practice_backtracking {

	public static int n = 4;
	public static int mArray[][] = new int[n][n];

	public static void printBoard(int mArray[][]) {
		System.out.println("");
		for (int i = 0; i < mArray.length; i++) {	
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void PrintBoard(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static boolean isSafe(int mArray[][], int r, int c) {
		int i =0, j = 0;
		for (i = 0; i < mArray.length; i++) {
			if (mArray[r][i] == 1) {
				return false;
			}
		}

		// upper left diagonal
		for (i = r, j = c; i>= 0 && j >= 0; i--, j--) {
			if (mArray[i][j] == 1) {
				return false;
			}
		}

		// down left diagonal
		for (i = r, j = c; i < n && j >= 0; i++, j--) {
			if (mArray[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public static boolean nQueenPlaced(int mArray[][], int N, int c) {

		if (c == n) {
			return true;
		}

		for (int r= 0; r < mArray.length; r++) {
			if (isSafe(mArray, r, c)) {
				mArray[r][c] = 1;
				if (nQueenPlaced(mArray, N, c + 1)) {
					return true;
				}
				mArray[r][c] = 0;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		if (nQueenPlaced(mArray, n - 1, 0)) {
			PrintBoard(mArray);
		} else {
			System.out.println(":(");
		}
 	}	
}