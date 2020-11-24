import java.util.Scanner;

public class Queue_Using_LinkedList {

	public class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node front = null;
	public static Node rear = null;
	public static int Queue_Size = 5;

	public void ENQUEUE(int data) {
		Node new_node = new Node(data);
		Node temp;
		Node current_node = front;

		if (Queue_Size == 0) {
			System.out.println("OverFlow :(");
		} else {
			if(front == null) {
			front = new_node;
			rear = new_node;

			Queue_Size--;

			} else {
				while (current_node.next != null) {
					current_node = current_node.next;
				}
				current_node.next = new_node;
				new_node.next = null;
				rear = new_node;

				Queue_Size--;
			}
		}

	}

	public void DisplayQueue() {
		Node current_node = front;

		if (front == null) {
			System.out.println("**** **** QUEUE **** ****");
			System.out.println("Queue is empty :(");
			System.out.println("**** **** **** **** ****");
		} else {
			System.out.println("**** **** QUEUE **** ****");
			while (current_node != null) {
				System.out.print(current_node.data + ",");
				current_node = current_node.next;
			}
			System.out.println("");
			System.out.println("**** **** **** **** ****");
		}
	}

	public void DEQUEUE() {
		Node temp;
		if (front == null) {
			System.out.println("UnderfFlow :(");
			return;
		} else {
			temp = front.next;
			front.next = null;
			front = temp;
		}
	}

	public static void main(String[] args) {

		Queue_Using_LinkedList obj = new Queue_Using_LinkedList();

		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0;

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
					obj.DisplayQueue();

					break;

				} case 2: {

					obj.DEQUEUE();
					obj.DisplayQueue();

					break;

				} case 3: {

					System.out.println("Front is : " + front.data + ", Rear is : " + rear.data);

					break;
				}
			}
		}
	}	
}