public class mColoring_Problem {

	public static int n = 4;
	public static int mArray[][] = { { 0, 1, 1, 1 }, 
	            	   { 1, 0, 1, 0 }, 
	           		   { 1, 1, 0, 1 }, 
	            	   { 1, 0, 1, 0 } }; 

	public static int color[] = new int[n];            	   

	public static void PrintColor(int color[]) {
		System.out.println("");
		for (int i : color) {
			System.out.print(i + ",  ");
		}
		System.out.println("");
	}

	public static boolean isSafe(int mArray[][], int c, int color[], int v) {
		for (int i = 0; i < n; i++) {
			if (mArray[v][i] == 1 && c == color[i]) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isColoringPossible(int mArray[][], int m, int color[], int v) {
		if (v == n) {
			PrintColor(color);
			return true;
		}

		for (int c = 1; c <= m; c++) {
			if (isSafe(mArray, c, color, v)) {
				color[v] = c;
				if (isColoringPossible(mArray, m, color, v + 1)) {
					return true;
				}
				color[v] = 0;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int m = 3; // no of color available
		if (isColoringPossible(mArray, m, color, 0)) {
			System.out.println("It's possible :)");  
		} else {
			System.out.println("It's not possible :)");  
		}
	}
}