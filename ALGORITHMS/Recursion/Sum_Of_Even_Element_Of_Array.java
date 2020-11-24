public class Sum_Of_Even_Element_Of_Array {

	public static int Sum_Even_Elements(int mArray[], int length, int sum) {

		if (length == 0) {
			if ((mArray[length] % 2) == 0) {
				sum += mArray[length];
				return sum;
			} else {
				return sum;
			}
		}

		if ((mArray[length] % 2) == 0) {
			sum += mArray[length]; 
		}

		return Sum_Even_Elements(mArray, length - 1, sum);
	}

	public static void main(String[] args) {
	    int mArray[] = { 5, 2, 3, 4, 5, 6, 7, 8 }; 

	    int sum = 0;
	    int ans = Sum_Even_Elements(mArray, mArray.length - 1, sum);
	    System.out.println("Answer is : " + ans);
	}
}