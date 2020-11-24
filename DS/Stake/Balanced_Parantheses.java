import java.util.*;

public class Balanced_Parantheses {

	public static Stack<Character> S = new Stack<>(); 

	public static boolean isSafe(char stack_char, char a) {
		if (stack_char == '{' && a == '}') {
			return true;
		} else if (stack_char == '(' && a == ')') {
			return true;
		} else if (stack_char == '[' && a == ']') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBalanced(char mArray[]) {
		for (int i = 0; i < mArray.length; i++) {
			if (mArray[i] == '{' || mArray[i] == '(' || mArray[i] == '[') {
				S.push(mArray[i]);
			}
			if (mArray[i] == '}' || mArray[i] == ')' || mArray[i] == ']') {
				if (S.isEmpty()) {
					return false;
				} else if (!isSafe(S.pop(), mArray[i])) {
					return false;
				}
			}
		}

		if (S.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
 	
	public static void main(String[] args) {
        char mArray[] = {'{', '{','(',')','}','[',']'}; 
        if (isBalanced(mArray)) {
        	System.out.println("Balanced");
        } else {
        	System.out.println("Not-Balanced");
        }
	}
}