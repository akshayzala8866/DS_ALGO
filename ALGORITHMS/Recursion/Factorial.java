public class Factorial {

	public static int Fact(int n) {
		if (n == 1) {
			return 1;
		}

		return n * Fact(n - 1);
	}

	public static int SumOfNaturalNo(int n) {
		if (n == 1) {
			return 1;
		}
		return n + SumOfNaturalNo(n - 1); 
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println(n + " Factorial : " + Fact(n));
		System.out.println(n + " Natural number sum : " + SumOfNaturalNo(n));
	}
}