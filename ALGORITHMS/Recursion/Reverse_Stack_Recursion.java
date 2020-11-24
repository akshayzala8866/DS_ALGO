import java.util.*; 

public class Reverse_Stack_Recursion {

	public static int top = -1;

	public static void PrintStack(int mArray[]) {
		int counter = 0;
		if (top == -1) {
			System.out.println("Stack ie empty");
		} else {
			while (counter <= top) {
				System.out.print(mArray[counter] + ", ");
				counter++;
			}	
			System.out.println("");
		}
	}

	public static void PushIntoStack(int mArray[], int data) {
		if (top == mArray.length - 1) {
			System.out.println("Stack over flow :(");
		} else {
			top++;
			mArray[top] = data;

			PrintStack(mArray);
		}
	}

	public static void PopFromStack(int mArray[]) {
		if (top == -1) {
			System.out.println("Stack under flow  :(");
		} else {
			top--;
			PrintStack(mArray);
		}
	}

	public static int[] ReverseStack(int mArray[], int start, int end) {
		if (start < end) {
			int temp = mArray[start];
			mArray[start] = mArray[end];
			mArray[end] = temp;

			ReverseStack(mArray, start + 1, end - 1);
		}

		return mArray;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0,size = 0;

		System.out.println("Enter size of the stack : ");
		size = s.nextInt();

		int mArray[] = new int[size];

		while (true) {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Reverse Stack");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();
			switch (ch) 
{
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					PushIntoStack(mArray, data);

					break;
				} case 2: {
					PopFromStack(mArray);

					break;
				} case 3: {
					mArray = ReverseStack(mArray, 0, top);
					PrintStack(mArray);
					System.out.println("Top : " + top);
				} 
			}
		}
	}
}