import java.util.*;

public class Sequential_Search {

	public void  SearchElement(int mArray[], int data) {
		int counter = 0;

		while (counter <= mArray.length) {
			if (mArray[counter] == data) {
				System.out.println(data + " is at " + counter);
				break;
			}
			++counter;
		}
	} 
	
	public static void main(String[] args) {

		Sequential_Search obj = new Sequential_Search();
		Scanner s = new Scanner(System.in);

		int length = 0, data = 0;

		System.out.println("Enter length of the array : ");
		length = s.nextInt();

		int mArray[] = new int[length];


		System.out.println("Enter elements : ");

		for (int i = 0; i < mArray.length; i++) {
			mArray[i] = s.nextInt();
		}

		System.out.println("");

		for (int i : mArray) {
			System.out.print(i + ", ");
		}
		System.out.println("");

		System.out.println("enter search element : ");
		data = s.nextInt();

		obj.SearchElement(mArray, data);
	}
}