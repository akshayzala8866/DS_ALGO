public class Replace_PI_In_String {

	public static String ReplaceStr(String str) {
		if (str.length() <= 1) {
			return str;
		}

		if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
			return "3.14" + ReplaceStr(str.substring(2, str.length()));
		}

		return str.charAt(0) + ReplaceStr(str.substring(1, str.length()));
	}

	public static void main(String[] args) {
		String str = "pipipi";
		System.out.println("ans : " + ReplaceStr(str));
	}
}