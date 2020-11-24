public class Find_Exponent {

	public static int Exponent(int base, int power) {

		if (power == 0) {
			return 1;
		}

		return (Exponent(base, power - 1) * base);
	}

	public static void main(String[] args) {
		int base = 3, power = 10 ;
		System.out.println("Answer is : " + Exponent(base, power));
	}
}