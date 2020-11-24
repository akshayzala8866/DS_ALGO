public class Min_Jump_To_Reach_End_recursion {

	public static int Find_Min_Jump(int mArray[], int l, int h) {
		if (l == h) {
			return 0;
		}

		if (mArray[l] == 0) {
			return Integer.MAX_VALUE;
		} 

		int min = Integer.MAX_VALUE;

		for (int i = l + 1; i <= h && i <= l + mArray[l]; i++) {
			int jump = Find_Min_Jump(mArray, i, h);

			if (jump != Integer.MAX_VALUE && jump + 1 < min) {
				min = jump + 1;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int mArray[] = { 2, 1, 3, 2 };

		int min_jump = Find_Min_Jump(mArray, 0, mArray.length - 1);
		System.out.println("minimum jump is : " + min_jump);
	}
}  