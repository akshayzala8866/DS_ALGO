public class Knigh_s_tour {

	public static int n = 8;

	public static void printTour(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.println("");
			for (int j = 0; j < mArray[0].length; j++) {
				System.out.print(mArray[i][j] + " : ");
			}
			System.out.println("");
		}
	}

	public static boolean isSafeMove(int xNext, int yNext, int mArray[][]) {
		if (xNext >= 0 && yNext >= 0 && yNext < n && xNext < n && mArray[xNext][yNext] == -1) {
			return true;
		} else {
			return false;
		}
	}
 
	public static boolean isTourPossibe(int x, int y, int moves, int mArray[][], int xMove[], int yMove[])	{
		if (moves == n * n) {
			return true;			
		}

		int xNext, yNext;

		for (int i = 0; i < xMove.length; i++) {
			xNext = x + xMove[i];
			yNext = y + yMove[i];
			if (isSafeMove(xNext, yNext, mArray)) {
				mArray[xNext][yNext] = moves;
				if (isTourPossibe(xNext, yNext, moves + 1, mArray, xMove, yMove)) {
					return true;
				}
				mArray[xNext][yNext] = -1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		
		int mArray[][] = new int[n][n];
		int xMove[] = {-2, -2, -1, -1, 1, 1, 2, 2};
		int yMove[] = {1, -1, 2, -2, 2, -2, 1, -1};

		for (int i = 0; i < mArray.length; i++) {
			for (int j = 0; j < mArray[0].length; j++) {
				mArray[i][j] = -1;
			}
		}

		mArray[0][0] = 0;

		if (isTourPossibe(0, 0, 1, mArray, xMove, yMove)) {
			System.out.println("Soliton is : ");
			printTour(mArray);
		}
	}
}