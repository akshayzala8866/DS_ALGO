import java.util.Scanner;

public class Stack_Using_Array {
	static int top = -1;
	static int mArray[] = new int[5];

	public boolean IsEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void Display_Stake (int mStake[]) {
		int counter = 0;

		if (top == -1) {
			System.out.println("Stake is empty :( "); 
		} else {
			System.out.println("**** **** Stake is **** ****");
			while (counter <= top) {
				System.out.print(mStake[counter] + ", ");
				counter++;
			}			
		}
	}

	public void PUSH(int data) {

		if(top == mArray.length-1) {
			System.out.println("Stake is over flow");
		} else {
			++top;
			mArray[top] = data;
		}

		Display_Stake(mArray);
		System.out.println("");
	}

	public void POP() {

		if (top == -1) {
			System.out.println("Stake is under flow");
		} else {
			--top;
			System.out.println("After  pop operaton ");
			Display_Stake(mArray);
			System.out.println("");			
		}
	}

	public void TopOftheStake() {
		if (IsEmpty()) {
			System.out.println("Empty :(");
		} else {
			System.out.println("Top of the stake is : " + mArray[top]);
		}
	}

	public static void main(String[] args) {

		Stack_Using_Array obj = new Stack_Using_Array();

		Scanner s =	new Scanner(System.in);
		int ch=0, data = 0;

		while (true) {
			System.out.println("**** **** **** ****");
			System.out.println("1. PUSH()");
			System.out.println("2. POP()");
			System.out.println("3. TOP()");
			System.out.println("4. IsEmpty()");
			System.out.println("**** **** **** ****");

			System.out.println("Enter your choice :");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("enter data : ");
					data = s.nextInt();

					obj.PUSH(data);

					break;
				} case 2: {
					obj.POP();

					break;
				} case 3: {
					obj.TopOftheStake();

					break;
				}
			}
		}
	}	
}