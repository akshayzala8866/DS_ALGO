import java.util.Scanner;

public class Delete_Row_from_TowD_Array {

	public static void printlnArray(int mArray[][]) {
		for(int i=0; i<mArray.length; i++) {
			for(int j=0; j<mArray[0].length; j++) {
				System.out.print(mArray[i][j] + ",");
			}
			System.out.println("");
		}
	}

	public static void DeleteRowFromArray(int mArray[][], int r) {

		int temp[][] = new int[mArray.length-1][mArray[0].length];

		if(r > mArray.length) {
			System.out.println("Sorry bro..!!");
		} else {
			for(int row=0; row<r; row++) {
				for(int col=0; col<mArray[0].length; col++) {
					temp[row][col] = mArray[row][col];
				}
			}

			for(int row=r+1; row<mArray.length; row++) {
				for(int col=0; col<mArray[0].length; col++) {
					temp[row-1][col] = mArray[row][col];
				}
			}
		}

		System.out.println("");
		System.out.println("After deleting " + r + "th row");
		System.out.println("");
		printlnArray(temp);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };

		System.out.println("Enter row number : ");
		int r = s.nextInt();

		System.out.println("Actual array is : ");
		System.out.println("");
		printlnArray(mArray);
		DeleteRowFromArray(mArray, r);
	}
} 