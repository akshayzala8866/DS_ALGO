//delete element from array at given index..!!
//naiv or basic approach..!!

import java.util.Scanner;

public class DeleteElementFormArray {

	public void DeleteElement(int mArray[], int index) {
		int temp[] = new int[mArray.length - 1];
		System.out.println("Length of new array is : " + temp.length);

		for(int i=0; i<index; i++) {
			temp[i] = mArray[i];
		}

		for(int i=index; i<temp.length; i++) {
			temp[i] = mArray[i+1];
		}

		System.out.println("New array is : ");

		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i] + ",");
		}
	}

	public static void main(String ar[]) {
		DeleteElementFormArray obj = new DeleteElementFormArray();
	
		Scanner s = new Scanner(System.in);
	
		System.out.println("Enter array size : ");
		int size = s.nextInt();
	
		int mArray[] = new int[size];

		System.out.println("Enter elements in array : ");

		for(int i=0; i<mArray.length; i++) {
			mArray[i] = s.nextInt();
		}
		
		System.out.println("Array elements are : ");
		for(int i=0; i<mArray.length; i++) {
			System.out.print(mArray[i] + ",");
		}

		System.out.println("Enter index : ");
		int index = s.nextInt();
		obj.DeleteElement(mArray, index);
	}	
}