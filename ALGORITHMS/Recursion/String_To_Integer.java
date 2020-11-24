public class String_To_Integer {

	public static int ReplaceStringToInteger(String str) {
		int zero = (int)'0';

		if (str.length() == 1) {
			return (str.charAt(0) - zero);
		}
		double recur_call = ReplaceStringToInteger(str.substring(1));
		double temp = str.charAt(0) - zero;

		temp = temp * Math.pow(10, str.length() -1) + recur_call;

		return (int)temp; 
	}

	public static int ReplaceStringToInteger_1(String str) {

		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			int temp = str.charAt(i) - '0';
			ans = (ans * 10) + temp;
		}

		return ans;
	}

	public static void main(String[] args) {
		String str = "12332";
		
		System.out.println(ReplaceStringToInteger(str));
		System.out.println(ReplaceStringToInteger_1(st	r));		
	}

}
