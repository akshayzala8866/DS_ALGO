import java.util.*;
import java.util.logging.Logger;

public class Reverse_Stack_Recursion_1 {

	public static Stack<Integer> st = new Stack<>();

	public static void Insert_At_Bottom(int temp) {
		if (st.isEmpty()) {
			st.push(temp);
		} else {
			int temp1 = st.pop();

			Insert_At_Bottom(temp);

			st.push(temp1);
		}
	}

	public static void reverse() {
		if (st.size() > 0) {
			int temp = st.pop();

			reverse();

			Insert_At_Bottom(temp);
		}
	}

	public static void main(String[] args) {

		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);

		System.out.println(st);
		System.out.println("TOS : " + st.peek());

		reverse();

		System.out.println(st);
		System.out.println("TOS : " + st.peek());
		
	}
}