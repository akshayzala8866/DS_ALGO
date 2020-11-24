import java.util.Scanner;

public class Get_Reverse_Diagonal_Of_Array {

	public static void GetReverseDiagonal(int mArray[][]) {
		int i = 0;
		int j = mArray.length-1;

		System.out.println("J : " + j);

		int rev_diagonal_array[] = new int[mArray.length];

		System.out.println("Size of rev_diagonal_array is : " + rev_diagonal_array.length);
		System.out.println("Size of row : " + mArray.length);
		System.out.println("Size of column : " + mArray[0].length);

		for(int row=0; row<mArray.length; row++) {
			for(int col=0; col<mArray.length; col++) {
				rev_diagonal_array[i] = mArray[i][j];
			}
			i++;
			j--;
		}

		for(int k=0; k<rev_diagonal_array.length; k++) {
			System.out.print(rev_diagonal_array[k] + ",");
		}
		System.out.println("");
		SumOfReverseDiagonalElements(rev_diagonal_array);

	}

	public static void SumOfReverseDiagonalElements(int mArray[]) {
		int sum = 0;
		for(int i=0; i<mArray.length; i++) {
			sum = sum + mArray[i];
		}

		System.out.println("Sum is : " + sum);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };

		GetReverseDiagonal(mArray);
	}
}