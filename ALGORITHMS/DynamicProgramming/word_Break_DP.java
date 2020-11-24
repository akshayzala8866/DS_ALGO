import java.util.*;

public class word_Break_DP {

	public static boolean hasWord(String prefix) {
		String dic[] = {"i", "love", "java"};

		for (int i = 0; i < dic.length; i++) {
			String temp = dic[i];
			if (temp.equals(prefix)) {
				return true;
			}
		}
		return false;
	}

	// recursive approach
	public static void word_break(String str, int length, String result) {
		for (int i = 1; i <= str.length(); i++) {
			String prefix = str.substring(0, i);

			if (hasWord(prefix)) {
				if (i == length) {
					result += prefix;
					System.out.println(result);
				}

				word_break(str.substring(i), length - i, result + prefix + " ");
			}
		}
	}

	public static void printWord(int visited[], String str) {
		int count = 0;

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 1) {
				System.out.print(str.substring(count, i) + " ");
				count = i;
			}
		}
	}

	public static boolean word_break1(String str, int visited[]) {
		if (str.length() == 0) {
			return true;
		}

		for (int i = 1; i <= str.length(); i++) {
			if (visited[i] == 0 && hasWord(str.substring(0, i))) {
				visited[i] = 1;
			}
			if (visited[i] == 1) {
				if (i == str.length()) {
					return true;
				}
				for (int j = i + 1; j <= str.length(); j++) {
					if (visited[j] == 0 && hasWord(str.substring(i, j))) {
						visited[j] = 1;
					}

					if (visited[j] == 1 && j == str.length()) {
						return true;
					}
				}
			} 
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str = s.nextLine();
		int visited[] = new int[str.length() + 1];
		word_break(str, str.length(), "");

		if (word_break1(str, visited)) {
			printWord(visited, str);			
		} else {
			System.out.println(":(");
		}
	}
}