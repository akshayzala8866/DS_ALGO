public class  Permitation_Of_String {

	public static String Swap_Str(String str, int a, int b) {

		if (a == b) {
			return str;
		} else {
			char temp;
			char mArray[] = str.toCharArray();
			temp = mArray[a];
			mArray[a] = mArray[b];
			mArray[b] = temp;

			return String.valueOf(mArray);
		}
	}

	public static void Permute_String(String str, int l, int r) {
		if (l == r) {
			System.out.print(str +  ", ");
			return;
		}

		for (int i = l; i < str.length(); i++) {
			str = Swap_Str(str, l, i);
			Permute_String(str, l + 1, r);
			str = Swap_Str(str, l, i);
		}
	}

	public static void main(String[] args) {
		String str = "ABC";
		Permute_String(str, 0, str.length() - 1);
	}
}