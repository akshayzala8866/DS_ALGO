import java.util.Scanner;

public class Sort_LinkedList {
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

	public void DisplayList() {
		Node current_node = head;

		if (head == null) {
			System.out.println("List is empty");
		} else {
			System.out.println("**** List is ****");
			while (current_node != null) {
				System.out.print(current_node.data + ",");
				current_node = current_node.next;
			}
		}	
	}

	public void SortLinkedList() {
		Node current_node = head;
		Node temp_pointer;
		int temp_value;

		if (head == null) {
			return ;
		} else {
			while (current_node != null) {
				temp_pointer = current_node.next;

				while (temp_pointer != null) {
					if (current_node.data > temp_pointer.data) {
						temp_value = current_node.data;
						current_node.data = temp_pointer.data;
						temp_pointer.data = temp_value;
					}
					temp_pointer = temp_pointer.next;
				}
				current_node = current_node.next;
			}
		}
	}

	public void InsertAtBegning(int data) {
		Node new_node = new Node(data);
		Node temp;
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			temp = head;
			new_node.next = temp;
			head = new_node;
		}
	}

	public void InsertAtBack(int data) {
		Node new_node = new Node(data);
		Node current_node = head;

		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			while (current_node.next != null) {
				current_node = current_node.next;
			}
			System.out.println("value is : " + current_node.data);
			current_node.next = new_node;
			new_node.next = null;
			tail = new_node;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ch = 0, index = 0, data = 0;

		Sort_LinkedList obj = new Sort_LinkedList();

		while (true) {
			System.out.println("1. Insert at Front.");
			System.out.println("2. Insert at Back.");
			System.out.println("3. Sort Linked List.");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {	
					System.out.println("Enter Data : ");
					data = s.nextInt();

					obj.InsertAtBegning(data);

					obj.DisplayList();
					System.out.println("");

					break;

				} case 2: {

					System.out.println("Enter Data : ");
					data = s.nextInt();

					obj.InsertAtBack(data);

					obj.DisplayList();
					System.out.println("");

					break;

				} case 3: {
					obj.SortLinkedList();

					obj.DisplayList();
					System.out.println("");

					break;

				}
			}

		}
	}
}