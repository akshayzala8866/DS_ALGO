import java.util.Scanner;

public class Queue_Using_Array {
	public static int mArray[] = new int[5];
	public static int front = -1, rear = -1, length = mArray.length;

	public void DisplayQueue(int mQueue[]) {
		int counter = 0;

		if (rear == -1) {
			System.out.println("**** **** QUEUE **** ****");
			System.out.println("Queue is empty :(");
			System.out.println("**** **** **** **** ****");

		} else {
			System.out.println("**** **** QUEUE **** ****");
			while (counter <= rear) {
				System.out.print(mQueue[counter] + ", ");
				++counter;
			}
			System.out.println("");
			System.out.println("**** **** **** ***** ****");
		}
	}

	public void ENQUEUE(int data) {
		if(rear == length - 1) {
			System.out.println("Queue overflow. :(");
		} else if (front == -1) {
			++front;
			++rear;
			mArray[front] = data;
		} else {
			++rear;
			mArray[rear] = data;
		}
		DisplayQueue(mArray);
	}

	public void DEQUEUE() {
		int counter = 0;
		if (front == -1) {
			System.out.println("Queue Underflow. :(");
		} else if (rear == 0) {
			--rear;
			--front;
		} else {
			while (counter <= rear) {
				mArray[counter] = mArray[counter + 1];
				counter++;
			}
			--rear;
		}
		DisplayQueue(mArray);
	}

	public static void main(String[] args) {

		Queue_Using_Array obj = new Queue_Using_Array();

		Scanner s = new Scanner(System.in);
		int ch = 0, data;

		while (true) {
			System.out.println("1. ENQUEUE");
			System.out.println("2. DEQUEUE");
			System.out.println("3. Front & Rear Elements..!!");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.ENQUEUE(data);
					
					break;

				} case 2: {
					obj.DEQUEUE();

					break;

				} case 3: {
					if(rear == -1) {
						System.out.println("Empty :(");
					} else {
						System.out.println("Front is : " + mArray[front] + ", Rear is : " + mArray[rear]);						
					}

					break;
				}
			}
		}
	}
} 