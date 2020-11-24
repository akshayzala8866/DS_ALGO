public class Word_Break_Problem {

	public static boolean dixnoryHasPrefix(String prefix) {
		
		String mArray[] = {"I", "Love", "Java"};
		for (int i = 0; i < mArray.length; i++) {
			String temp = mArray[i];
			if (temp.equals(prefix)) {
				return true;
			}
		}
		return false;
	}

	public static void FindString(String str, int n, String result) {
		for (int i = 1; i <= n; i++) {
			String prefix = str.substring(0, i);
			if (dixnoryHasPrefix(prefix)) {
				if (i == n) {
					result += prefix;
					System.out.println(result);
				}
				FindString(str.substring(i), n - i, result + prefix + " ");
			}
		}
	}

	public static void main(String[] args) {
		String str = "ILoveJava";
		FindString(str, str.length(), "");
	}
}