public class Min_Jump_To_Reach_End {

	public static int min_Function(int a, int b) {
		if (a <= b) {
			return a;
		} else {
			return b;
		}
	}

	public static int FindMinJump(int mArray[], int l) {
		int jump_array[] = new int[mArray.length];
		int path[] = new int[mArray.length];

		if (l == -1 || mArray[0] == 0) {
			return Integer.MAX_VALUE;
		}

		jump_array[0] = 0;
		path[0] = 0;

		for (int i = 1; i < mArray.length; i++) {
			jump_array[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + mArray[j] && jump_array[j] != Integer.MAX_VALUE) {
					jump_array[i] = min_Function(jump_array[i], jump_array[j] + 1);
					path[i] = j;
					break;
				}
			}	
		}

		System.out.println("");
		for (int a : path) {
			System.out.print(a + ", ");
		}
		System.out.println("");

		return jump_array[jump_array.length - 1];
	}

	public static void main(String[] args) {
        int mArray[] = {  2, 1, 3, 2, 3, 4, 5, 1, 2, 8 }; 

		int jump = FindMinJump(mArray, mArray.length - 1);

		System.out.println("Minimum jump is : " + jump);
	}
}