public class Tower_Of_Henoi {

	public static void TOH(char a, char b, char c, int n) {
		if (n == 1) {
			System.out.println("Move disk " + n +" from " + a + " to " + c);
			return;
		}

		TOH(a, c, b, n - 1);
		System.out.println("Move disk " + n +" from " + a + " to " + c);
		TOH(b, a, c, n - 1);

 	}

	public static void main(String[] args) {
		int n = 2.;
		System.out.println("Tower of henoi for disk : " + n);

		TOH('a', 'b', 'c', n);
	}
}