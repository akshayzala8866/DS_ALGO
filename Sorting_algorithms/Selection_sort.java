import java.util.Scanner;

public class Selection_sort {

	public static void PrtintSortedArray(int mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(mArray[i] + "  ");
		}
	}

	public static void SelectionSort(int mArray[]) {
		int temp = 0, min_element;

		for (int i = 0; i < mArray.length - 1; i++) {
			min_element = i; 
			for (int j = i + 1; j < mArray.length; j++) {
				if (mArray[j] < mArray[min_element]) {
					min_element = j; 
				}
			}
			temp = mArray[min_element];
			mArray[min_element] = mArray[i];
			mArray[i] = temp;
		}

		PrtintSortedArray(mArray);
	}

	public static void FindMinimumOfTheArray(int mArray[]) {
		int min = mArray[0];
		for (int i = 1; i < mArray.length; i++) {
			if (mArray[i] < min) {
				min = mArray[i];
			}
		}
		System.out.println("");
		System.out.println("Minimum is : " + min);	
	}

	public static String[] InsertDataIntoStringArray(String str_array[]) {

		Scanner s = new Scanner(System.in);

		for (int i = 0; i < str_array.length; i++) {
			str_array[i] = s.nextLine();
		}
		return str_array;
	} 

	public static String[] SelectionSort_In_String(String str_array[]) {
		String temp;
		int min_element;

		for (int i = 0; i < str_array.length - 1; i++) {
			min_element = i;
			for (int j = i + 1; j < str_array.length; j++) {
				if (str_array[j].compareTo(str_array[min_element]) < 0) {
					min_element = j;
				}
			}
			temp = str_array[min_element];
			str_array[min_element] = str_array[i];
			str_array[i] = temp;
		}

		return str_array;
	}

	public static void main(String[] args) {
		int mArray[] = {13, 14, 12, 11, 10};
		String str_array[]  = new String[5];

		System.out.println("Unsorted array : ");
		PrtintSortedArray(mArray);
		System.out.println("");
		SelectionSort(mArray);
		FindMinimumOfTheArray(mArray);

		// str_array = InsertDataIntoStringArray(str_array);

		// for (int i = 0; i < str_array.length; i++) {
		// 	System.out.print(str_array[i] + " ");
		// }

		// str_array = SelectionSort_In_String(str_array);
		
		// System.out.println("After string array is sortes : ");
		
		// for (int i = 0; i < str_array.length; i++) {
		// 	System.out.print(str_array[i] + " ");
		// }

	}
}