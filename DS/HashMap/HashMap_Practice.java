import java.util.*;

public class HashMap_Practice {
	public static int n = 4;
	public static HashMap< Integer, ArrayList<Integer> > map = new HashMap<Integer, ArrayList<Integer>>(n);

	public static void main(String[] args) {
		map.put(0, 1);
		map.put(0, 3);
		map.put(3, 0);
		map.put(1, 0);
		map.put(2, 3);
		map.put(3, 2);
		map.put(2, 1);
		map.put(1, 2);

		for (Map.Entry< Integer, ArrayList<Integer> > entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : ");
			for (int i : entry.getValue()) {
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
}