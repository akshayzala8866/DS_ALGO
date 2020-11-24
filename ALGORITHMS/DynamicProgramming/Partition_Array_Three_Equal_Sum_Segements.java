import java.util.*;

public class Partition_Array_Three_Equal_Sum_Segements {

	public static int pos1 = -1, pos2 = -1;

	public static boolean issetPossible(int set[], int length) {
		int pre[] = new int[length];
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += set[i];
			pre[i] = sum;
		}

		int suf[] = new int[length];
		sum = 0;
		for (int i = length - 1; i >= 0; i--) {
			sum += set[i];
			suf[i] = sum;
		}

		int i = 0, j = length - 1;
		while (i < j) {
			if (pre[i] == sum / 3) {
				pos1 = i;
			}
			if (suf[j] == sum / 3) {
				pos2 = j;
			}

			if (pos2 != -1 && pos1 != -1) {
				if (suf[pos1 + 1] - suf[pos2] == sum / 3) {
					return true;
				} else {
					return false;
				}
			}

			if (pre[i] < suf[j]) {
				i++;
			} else {
				j--;
			}
 		}

 		return false;
	}

	public static void printSets(int set[]) {
		for (int i = 0; i <= pos1; i++) {
			System.out.print(set[i] + " ");
		}
		System.out.println("");
		for (int i = pos1 + 1; i < pos2; i++) {
			System.out.print(set[i] + " ");
		}
		System.out.println("");
		for (int i = pos2; i < set.length; i++) {
			System.out.print(set[i] + " ");
		} 
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int set[] = new int[n];
		for (int i = 0; i < n; i++) {
			set[i] = s.nextInt();
 		}
 		if (issetPossible(set, set.length)) {
 			printSets(set);
 		} else {
 			System.out.println(":(");
 		}
	}
}