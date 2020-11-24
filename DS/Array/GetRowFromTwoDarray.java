import java.util.Scanner;

public class GetRowFromTwoDarray {

	public static void GetRow(int mArray[][], int row_length, int row_no) {
		
		if(row_no > mArray.length-1) {
			System.out.println("Sorry bro :-(");
		} else {
			int row_array[] = new int[mArray[0].length];

			System.out.println("Size of array is : " + row_array.length);

			for(int i=0; i<mArray.length; i++) {
				for(int j=0; j<mArray[0].length; j++) {
					row_array[j] = mArray[row_no][j];
				}	
			}

			System.out.println("Array is : ");
			for(int i=0; i<row_array.length; i++) {
				System.out.println(row_array[i] + ",");
			}
		}	
	}

	public static void printTwoDArray(int mArray[][]) {
		for(int i=0; i<mArray.length; i++) {
			for(int j=0; j<mArray[0].length; j++) {
				System.out.print(mArray[i][j]);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[][] = { {1, 3}, {2, 4}, {2, 34}, {4, 4} };

		int row_length = mArray.length;
		int col_length = mArray[0].length;
		System.out.println("Enter number row number : ");
		int rowno = s.nextInt();

		GetRow(mArray, row_length, row_no);
		//printTwoDArray(mArray);
	}
}