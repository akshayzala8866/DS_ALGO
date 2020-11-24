public class Subset_sum_Problem {

	public static void Print_Element(int elements[]) {
		System.out.println("");
		for (int i : elements) {
			System.out.print(i + ", ");
		}
	}

	public static boolean Find_Sum(int mArray[], int n, int elements[], int sum) {

		System.out.println("n : " + n);
		if (sum == 0) {
			return true;
		}

		if (n == -1 && sum != 0) {
			return false;	
		}

		return Find_Sum(mArray, n - 1, elements, sum) || Find_Sum(mArray, n - 1, elements, sum - mArray[n]);
	}

	public static void main(String[] args) {
		int mArray[] = { 5, 4, 3, 2, 1 };
		int elements[] = new int[mArray.length];
		int sum = 9;

		if (Find_Sum(mArray, mArray.length - 1, elements, sum)) {
			System.out.println("True");
			Print_Element(elements);
		} else {
			System.out.println("can not find feasible solution :(");
		}
	}
}