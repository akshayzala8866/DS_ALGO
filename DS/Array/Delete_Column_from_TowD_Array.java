import java.util.Scanner;

public class Delete_Column_from_TowD_Array {

	public static void PrintArray(int mArray[][]) {
		for(int i=0; i<mArray.length; i++) {
			for(int j=0; j<mArray[0].length; j++) {
				System.out.print(mArray[i][j] + ", ");
			}
			System.out.println("");
		}
	}

	public static void DeleteColumnFromArray(int mArray[][], int c) {
		
		int temp[][] = new int[mArray.length][mArray[0].length-1];
		
		if(c >= mArray[0].length) {
			System.out.println("Sorry bro..!!");
		} else {
			for(int row=0; row<mArray.length; row++) {
				for(int col=0; col<c; col++) {
					temp[row][col] = mArray[row][col];
				}
			}

			for(int row=0; row<mArray.length; row++) {
				for(int col=c; col<mArray[0].length-1; col++) {
					temp[row][col] = mArray[row][col+1];
				}
			}			
							
			System.out.println("");
			System.out.println("After Deleting "+ c + " Column");
			System.out.println("");
			PrintArray(temp);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[][] = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16} };

		System.out.println("Enter Column number : ");
		int c = s.nextInt();

		System.out.println("Before Deleting Column");
		System.out.println("");
		PrintArray(mArray);
		DeleteColumnFromArray(mArray, c);		
	}	
}