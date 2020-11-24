public class Binary_Search_Recursive {

	public static void BinarySearch(int mArray[], int start, int end, int n) {
		if (start < end) {
			int mid = (start + end) / 2;

			if (mArray[mid] == n) {
				System.out.println(n + " is present at Index : " + mid);				
			} else if (n < mArray[mid]) {
				BinarySearch(mArray, start, mid - 1,n);
			} else {
				BinarySearch(mArray, mid + 1, end, n);
			}
 		}
	}

	public static void main(String[] args) {
		int mArray[] = { 0, 1, 2, 10, 6, 7, 8 };
		int n = 10;

		BinarySearch(mArray,0, mArray.length - 1, n);
	}
}