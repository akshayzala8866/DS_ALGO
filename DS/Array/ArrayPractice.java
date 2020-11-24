import java.util.Scanner;

public class ArrayPractice {
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter String you want to reverse : ");
		String str = s.nextLine();

		String rev_Str = ReverserString(str);
		System.out.println("Reverse String is : " + rev_Str); 
	}
		
	public static String ReverserString(String str) {
		char str_array[] = new char[str.length()];
		char rev_array[] = new char[str_array.length];

		for(int i=0; i<str_array.length; i++) {
			str_array[i] = str.charAt(i);
		}
		
		int temp = 0;
		for(int i=str_array.length; i>0; i--) {
			rev_array[i-1] = str_array[temp];
			temp++;
		}
		String rev_str = new String(rev_array);
		
		return rev_str;
	}
}