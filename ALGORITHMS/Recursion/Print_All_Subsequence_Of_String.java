public class Print_All_Subsequence_Of_String {

	public static String[] Find_SubSequence(String str) {
		if (str.length() == 0) {
			String ans[] = {""};
			return ans;
		}

		String temp[] = Find_SubSequence(str.substring(1));
		String ans[] = new String[2 * temp.length];

		for (int i = 0; i < temp.length; i++) {
			ans[i] = temp[i];
		}

		for (int i = 0; i < temp.length; i++) {
			ans[i + temp.length] = temp[i] + str.charAt(0); 
		}

		return ans;
	}

	public static void Find_SubSequence_1(String str, String output) {
		if (str.length() == 0) {
			System.out.print(output + ", ");
			return;
		}

		Find_SubSequence_1(str.substring(1), output);
		Find_SubSequence_1(str.substring(1), output + str.charAt(0));
	}

	public static void main(String[] args) {
		String input = "ABc";
		String output = "";

		String ans[] = Find_SubSequence(input);

		for (String a : ans) {
			System.out.print(a + ", ");
		}
		System.out.println("");

		// Find_SubSequence_1(input, output);		

	}
}