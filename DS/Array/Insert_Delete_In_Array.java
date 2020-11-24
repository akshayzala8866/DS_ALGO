import java.util.Scanner;

public class Insert_Delete_In_Array {

	public static void PrintArray(int mArray[]) {
		for(int i=0; i<mArray.length; i++) {
			System.out.print(mArray[i] + ",");
		}
	}

	public static int[] InsertInFront(int mArray[], int Value) {
		System.out.println("Values is : " + Value);
		int temp[] = new int[mArray.length + 1];
		for(int i=0; i<temp.length; i++) {
			if(i == 0) {
				temp[i] = Value;
			} else {
				temp[i] = mArray[i-1];
			}
		}

		return temp;
	}

	public static int[] InsertInBack(int mArray[], int Value) {
		int temp[] = new int[mArray.length + 1];
		for(int i=mArray.length; i>=0; i--) {
			if(i == mArray.length) {
				temp[i] = Value;
			} else {
				temp[i] = mArray[i];
			}
		}
		return  temp;
	}

	public static int[] DeleteInFront(int mArray[]) {

		int temp[] = new int[mArray.length - 1];

		if(mArray.length == 1) {
			System.out.println("Sorry bro..!!");
		} else {

			for(int i=0; i<temp.length; i++) {
				temp[i] = mArray[i+1];
			}
		}

		return temp;
	}

	public static int[] DeleteInBack(int mArray[]) {
		int temp[] = new int[mArray.length - 1];

		System.out.println("Size of temp array is : " + temp.length);

		if(mArray.length == 1) {
			System.out.println("Sorry bro..!");
		} else {
			for(int i=temp.length; i>0; i--) {
				temp[i-1] = mArray[i-1];
			}
		}

		return temp;
	}

	public static int[] InsertInGivenInex(int mArray[], int Value, int index) {
		int temp[] = new int[mArray.length + 1];
		System.out.println("Value : " + Value);
		System.out.println("index : " + index);

		for(int i=0; i<index; i++) {
			temp[i] = mArray[i];
		}

		for (int i=index; i<temp.length; i++)  {
			if(i == index) {
				temp[i] = Value;
			} else {
				temp[i] = mArray[i-1];
			}
		}

		return temp;
	}

	public static int[] DeleteFromGivenIndex(int mArray[], int index) {
		int temp[] = new int[mArray.length - 1];
		// int count = index;
		System.out.println("arra size : " + mArray.length);
		System.out.println("temp arra size : " + temp.length);
		
		for(int i=0; i<temp.length; i++) {
			if(i >= index) {
				temp[i] = mArray[i+1];
			} else {
				temp[i] = mArray[i];
			}
		} 
		return temp;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mArray[] = {1, 2, 3, 4, 5};
		int Value = 0;
		int index = 0;
		
		while(true) {

			System.out.println("");
			System.out.println("****************************");
			System.out.println("1. Insert in front.");
			System.out.println("2. Insert in back.");
			System.out.println("3. Delete in front.");
			System.out.println("4. Delete in back.");
			System.out.println("5. Insert in given index.");
			System.out.println("6. Delete in given index.");
			System.out.println("****************************");
			System.out.println("");

			System.out.println("Enter your choise : ");
			int ch = s.nextInt();

			switch (ch) {
				
				case 1: {
					System.out.println("Enter Value  ");
					Value = s.nextInt();
					mArray = InsertInFront(mArray, Value);
					PrintArray(mArray);
					System.out.println("");

					break;
				} case 2: {
					System.out.println("Enter Value  ");
					Value = s.nextInt();
					mArray = InsertInBack(mArray, Value);
					PrintArray(mArray);
					System.out.println("");

					break;
				} case 3: {
					mArray = DeleteInFront(mArray);
					PrintArray(mArray);
					System.out.println("");

					break;
				} case 4: {
					mArray = DeleteInBack(mArray);
					PrintArray(mArray);
					System.out.println("");

					break;
				} case 5: {
					System.out.println("Enter index number for insert Value  : ");
					index = s.nextInt();

					System.out.println("Enter vaule : ");
					Value = s.nextInt();
					
					if(index > mArray.length) {
						System.out.println("Sorry bro... Array size is : " + mArray.length);
					} else {
						mArray = InsertInGivenInex(mArray, Value, index);
						PrintArray(mArray);
						System.out.println();	
					}

					 break;
				} case 6: {
					System.out.println("Enter index number for delete Value : ");
					index = s.nextInt();

					if(index > mArray.length) {
						System.out.println("StackOverflowErrory bro... array size is : " + mArray.length);
					} else {
						mArray = DeleteFromGivenIndex(mArray, index);
						PrintArray(mArray);
						System.out.println("");
					}

					break;
				} default: {
					System.out.println("      Please enter right choise..!!");
				}

			}
		}
	}
}