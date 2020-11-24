import java.util.*;

public class Euqal_sum_set_of_array_Recursion {

	public static ArrayList<Integer> set1 = new ArrayList<>();
	public static ArrayList<Integer> set2 = new ArrayList<>();

	public static void prinSets() {
		for (int i : set1) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (int i : set2) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static boolean findSets(int set[], int length, int sum1, int sum2, int pos) {
		if (pos == length) {
			if (sum2 == sum1) {
				prinSets();
				return true;
			} else {
				return false;
			}
		}

		set1.add(set[pos]);

		boolean ans = findSets(set, length, sum1 + set[pos], sum2, pos + 1);

		if (ans) {
			return true;
		} 

		set1.remove(set1.size() - 1);
		set2.add(set[pos]);

		ans = findSets(set, length, sum1, sum2 + set[pos], pos + 1);

		if (ans == false) {
			if (set2.size() > 0) {
				set2.remove(set2.size() - 1);
			}
		}

		return ans;
	}

	public static boolean isSetPossible(int set[], int length) {
		int sum = 0;
		for (int i : set) {
			sum += i;
		}

		if (sum % 2 != 0) {
			return false;
		}

		// set, length, sum1, sum2, position
		return findSets(set, length, 0, 0, 0);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int set[] = new int[n];
		for (int i = 0; i < n; i++) {
			set[i] = s.nextInt();
		}
		if (isSetPossible(set, set.length) == false) {
			System.out.println(":(");
		}
	}
}