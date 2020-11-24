import java.util.*;

public class nuts_bolts_Map {

	public static void PrintValues(char nuts[], char bolts[]) {
		for (char i : nuts) {
			System.out.print(i + " ");
		}
		System.out.println("");
		for (char i : bolts) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}


	public static void MapMethod(char nuts[], char bolts[], int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(nuts[i], i);
		}
		
		for (int i = 0; i < n; i++) {
			if (map.containsKey(bolts[i])) {
				nuts[i] = bolts[i];
			}
		}
	}

	public static void main(String[] args) {
		char nuts[] = {'@', '#', '$', '%', '^', '&'}; 
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        MapMethod(nuts, bolts, nuts.length);

        PrintValues(nuts, bolts);
	}
}