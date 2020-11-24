import java.util.Scanner;

public class Multiplication_of_Matrix {

	public static void PrintMatrix(int mMatrix[][]) {
		for(int i=0; i<mMatrix.length; i++) {
			for(int j=0; j<mMatrix[0].length; j++) {
				System.out.print(mMatrix[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static void MultiplicationOfMatrix(int matrix_1[][], int matrix_2[][] ) {
		int mul_matrix[][] = new int[matrix_1.length][matrix_2[0].length];

		System.out.println("Row : " + mul_matrix.length);
		System.out.println("Column : " + mul_matrix[0].length);

		if(matrix_1[0].length == matrix_2.length) {
			//resultion array....
			for(int row=0; row<mul_matrix.length; row++) {
				for(int col=0; col<mul_matrix[0].length; col++) {
					for(int count=0; count<mul_matrix.length; count++) {
						mul_matrix[row][col] = 	mul_matrix[row][col] + (matrix_1[row][count] * matrix_2[count][col]);
					}
				}
			}
		} else {
			System.out.println("Sorry bro..!!");
		}

		PrintMatrix(mul_matrix);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int matrix_1[][] = { {1, 5, 2}, {3, 0, 1}, {2, 4, 3} };
		int matrix_2[][] = { {4, 1}, {1, 6}, {3, 1}};

		MultiplicationOfMatrix(matrix_1, matrix_2);

	}	
}