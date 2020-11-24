//remove duplicates values from array..!!
 

import java.util.Scanner;

public class RemoveDuplicateElement {

	public void RemoveDuplicates(int mArray[], int size) {
		if(size == 0 || size == 1) {
			System.out.println("No duplicate values in array :-)");
		}

		int temp[] = new int[size];
		
		int j = 0;
		for(int i=0; i<mArray.length-1; i++) {
			if(mArray[i] != mArray[i+1]) {
				temp[j] = mArray[i];
				j++;
			}
		}

		temp[j] = mArray[size-1];
		
		for(int i=0; i<=j; i++) {
			mArray[i] = temp[i];
		}

		for(int i=0; i<=j; i++) {
			System.out.print(mArray[i] + ",");
		}
	}
	
	public static void main(String ar[]) {

		RemoveDuplicateElement obj = new RemoveDuplicateElement();		

		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of Array : ");
		int size = s.nextInt();
		int mArray[] = new int[size];

		System.out.println("Enter elements : ");
		for(int i=0; i<size; i++) {
			mArray[i] = s.nextInt();	
		}
		
		obj.RemoveDuplicates(mArray, mArray.length);
	}
}