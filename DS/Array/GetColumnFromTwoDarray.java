import java.util.Scanner;

public class GetColumnFromTwoDarray {

	public static void GetColumn(int mArray[][], int index) {
		
		if(index >= mArray.length) {
			System.out.println("Sorry bro..!");
		} else {
		
			int temp[] = new int[mArray.length];

			System.out.println("Size of temp array is : " + temp.length);

			for(int i=0; i<mArray.length; i++) {
				for(int j=0; j<mArray[0].length; j++) {
					temp[j] = mArray[j][index];
				}
			}

			for(int i=0; i<temp.length; i++) {
				System.out.println(temp[i] + ",");
			}

		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of column : ");
		int index = s.nextInt();
	
		int mArray[][] = { {1, 3, 43}, {2, 4, 2}, {4, 5, 3} };

		GetColumn(mArray, index);		
	}
}