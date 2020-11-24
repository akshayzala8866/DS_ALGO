import java.util.Scanner;

public class Stake_Using_LinkedList {

	public class Node {

		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null; 
		}
	}

	Node head = null;
	Node tail = null;
	int StakteSize = 5;

	public int LengthOfTheList() {
		Node current_node = head;
		int length = 0;

		if (current_node == null) {
			return 0;
		} else {
			while (current_node != null) {
				length++;
				current_node = current_node.next;
			}
			return length;
		}
	}

	public void PUSH(int data) {
		Node new_node = new Node(data);
		Node current_node = head;

		if(head == null) {
			head = new_node;
			tail = new_node;
			--StakteSize;
		} else {

			if(StakteSize == 0) {
				System.out.println("Stake is over Flow stake size is 5");
			} else {

				while (current_node.next != null) {
				current_node = current_node.next;
				}
				System.out.println("Value is : " + current_node.data);	


				current_node.next = new_node;
				new_node.next = null;
				tail = new_node;
				--StakteSize;

			}
		}
	}

	public void DisplayStake() {
		Node current_node = head;

		if(current_node == null) {
			System.out.println("**** **** STAKE **** ****");	
			System.out.println("Empty :( ");	
			System.out.println("**** **** **** **** ****");	

		} else {
			System.out.println("**** **** STAKE **** ****");	

			while (current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.next;
			}
			System.out.println("");	
			System.out.println("**** **** **** **** ****");	

		}
	}

	public void POP() {
		int length = 0, counter = 1;
		Node current_node = head;

		length = LengthOfTheList();

		System.out.println("length  : " + length);

		if(length == 0) {
			System.out.println("Stake is under flow");
		} else if (length == 1) {
			head = null;
			tail = null;
		} else {
			while (counter < length - 1) {
				counter++;
				current_node = current_node.next;
			}

			current_node.next = null;
			tail = current_node;

		}
	}

	public Node TopOfTheStake() {
		Node current_node = tail;

		return current_node;
	}

	public static void main(String[] args) {

		Stake_Using_LinkedList obj = new Stake_Using_LinkedList();

		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0; 

		while (true) {
			System.out.println("1. PUSH()");
			System.out.println("2. POP()");
			System.out.println("3. TopOfTheStake()");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter your data : ");
					data = s.nextInt();

					obj.PUSH(data);
					obj.DisplayStake();
					System.out.println("");

					break;

				} case 2: {
					
					obj.POP();
					obj.DisplayStake();
					System.out.println("");

					break;

				} case 3: {
					Node current_node =  obj.TopOfTheStake();

					if (current_node == null) {
						System.out.println("");
						System.out.println("Stake is empty :(");
						System.out.println("");
					} else {
						System.out.println("Top of the sake is : " + current_node.data);
					} 

					break;
				} 
			}

		}
	}
}