public class Generate_N_Bits_Binary_Numbers {

	public static void PrintNumbers(int mArray[]) {
		System.out.println("");
		for (int i : mArray) {
			System.out.print(i + " ");
		}
		
	} 

	public static void generate_Binary(int mArray[], int n, int start) {
		if (start == n) {
			PrintNumbers(mArray);
			return;
		}

		mArray[start] = 0;
		generate_Binary(mArray, n, start + 1);

		mArray[start] = 1;
		generate_Binary(mArray, n, start + 1);
	}

	public static void main(String[] args) {
		int n = 5;
		int mArray[] = new int[n];

		generate_Binary(mArray, n, 0);
	}
}