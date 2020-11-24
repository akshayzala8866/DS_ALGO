import java.util.Scanner;

public class Addition_of_matrix {

	public static void PrintMatrix(int mMatrix[][]) {
		for(int row=0; row<mMatrix.length; row++) {
			for(int col=0; col<mMatrix[0].length; col++) {
				System.out.print(mMatrix[row][col] + "  ");
			}
			System.out.println("");
		}
	}

	public static void AddidionOfMatrix(int matrix_1[][], int matrix_2[][]) {

		int sum_matrix[][] = new int[matrix_1.length][matrix_1[0].length];

		if (matrix_1.length != matrix_2.length) {
			System.out.println("Sorry bro.!!");
		} else if (matrix_1[0].length != matrix_2[0].length) {
			System.out.println("Sorry bro.!!");
		} else {
			for(int row=0; row<matrix_1.length; row++) {
				for(int col=0; col<matrix_1[0].length; col++) {
					sum_matrix[row][col] = matrix_1[row][col] + matrix_2[row][col];
				}
			}

			System.out.println("Addition of Matrix is : ");
			PrintMatrix(sum_matrix);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int matrix_1[][] = { {1, 2}, {3, 4} };
		int matrix_2[][] = { {1, 2}, {3, 4} };

		System.out.println("First matrix : ");
		PrintMatrix(matrix_1);

		System.out.println("Second matrix : ");
		PrintMatrix(matrix_2);

		AddidionOfMatrix(matrix_1, matrix_2);
	}
}