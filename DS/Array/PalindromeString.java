import java.util.Scanner;

public class PalindromeString {

	public static boolean CheckPalindeom(char char_array[], int size, String str) {
		char temp[] = new char[size];
		
		int j = size-1;
 		for(int i=0; i<size; i++) {
			temp[j] = char_array[i];
			j--;
		}

		String temp_str = new String(temp);
		
		if(str.equals(temp_str)) {
			return true;		
		} else { 
			return false;
		}
	}

	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter String : ");
		String str = s.nextLine();
		char char_array[] = new char[str.length()];
		for(int i=0; i<str.length(); i++) {
			char_array[i] = str.charAt(i);
		}

		System.out.println("Character array size : " + char_array.length);

		if(CheckPalindeom(char_array, char_array.length, str)) {
			System.out.println(str + " is palindrom..!!");
		} else {
			System.out.println(str + " is not-palindrom..!!");			
		}
	}
}