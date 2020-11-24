import java.util.*;

public class Practice {

	public static void Sort(int arr[], int n) {
		int min_index = 0, temp = 0;
		for (int i = 0; i < n; i++) {
			min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}
			temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		} 
		Sort(arr, n);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}	
}