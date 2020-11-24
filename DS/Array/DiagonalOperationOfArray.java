import java.util.Scanner;

public class DiagonalOperationOfArray {

	public static void GetDiagonalElements(int mArray[][]) {
		int j = 0;

		System.out.println("Size of row is : " + mArray.length);
		System.out.println("Size of column is : " + mArray[0].length);


		int diagola_array[] = new int[mArray.length];

		System.out.println("length of diagola_array is : " + diagola_array.length);
	
		for(int row=0; row<mArray.length; row++) {
			for(int col=0; col<mArray[0].length; col++) {
				if(row == col) {
					diagola_array[j] = mArray[row][col];
					j++;
				}
			}
		}
		System.out.println("diagola_array is : " + j);

		for (int i=0; i<diagola_array.length; i++) {
			System.out.print(diagola_array[i] + ",");

		}

		System.out.println("");
		SumOfDiagonal(diagola_array);
	}

	public static void SumOfDiagonal(int diagola_array[]) {
		int sum = 0;
		for(int i=0; i<diagola_array.length; i++) {
			sum = sum + diagola_array[i]; 
		}

		System.out.println("Sum is : " + sum);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[][] = { {1, 2, 3}, {2, 3, 5}, {16, 7, 8} };

		GetDiagonalElements(mArray);

	}

}