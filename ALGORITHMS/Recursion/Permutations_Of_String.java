public class Permutations_Of_String	{

	public static String Swap_str(String str, int start, int end) {
		if (start == end) {
			return str;
		} else {
			char temp;
			char temp_array[] = str.toCharArray();
			temp = temp_array[start];
			temp_array[start] = temp_array[end];
			temp_array[end] = temp;

			return String.valueOf(temp_array);
		}
	}

	public static void Permute_Str(String str, int lb, int ub) {
		if (lb == ub) {
			System.out.println(str + ", ");
		} else {
			for (int i = lb; i < str.length(); i++) {
				str = Swap_str(str, lb, i);
				Permute_Str(str, lb + 1, ub);
				str = Swap_str(str, lb, i);
			}
		}
	}  

	public static void main(String[] args) {
		String str = "ABC";
		Permute_Str(str, 0, str.length() - 1);
	}
}