import java.util.Scanner;

public class TwoD_Array {

	public static void AddElementsInArray(int row, int columns) {
			
		Scanner s = new Scanner(System.in);
		
		int mArray[][] = new int[row][columns];
		System.out.println("Enter elemets in 2D-array : ");

		for (int i=0; i<row; i++) {
			for(int j=0; j<columns; j++) {
				mArray[i][j] = s.nextInt();
			}
		}

		System.out.println("Size of 2d-Array is : " + mArray.length);			

		ShowTwoDArray(mArray, row, columns);
	}

	public static void ShowTwoDArray(int mArray[][], int row, int columns) {

		for(int i=0; i<row; i++) {
			for(int j=0; j<columns; j++) {
				System.out.print("[ " +mArray[i][j] + " ] ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter size of rows : ");
		int row = s.nextInt();

		System.out.println("Enter size of columns : ");
		int columns = s.nextInt();
		
		AddElementsInArray(row, columns);
		
	}
}