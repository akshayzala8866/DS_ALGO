import java.util.*;

public class Sequential_Search_LinkedList {

	public class Node {
		public int data;
		public Node right;

		public Node(int data) {
			this.data = data;
			this.right = null;
		}
	}
	Node head = null;
	Node rear = null;

	public void PrintLinkedList() {
		Node current_node = head;

		if (current_node == null) {
			System.out.println("List is empty :(");
		} else {
			while (current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.right;
			}
			System.out.println("");
		}
	}

	public void AddDataIntoLinkedList(int data) {
		Node new_node = new Node(data);
		Node current_node = null;

		if (head == null) {
			head = new_node;
			rear = new_node;

			rear.right = null;
		} else {
			current_node = head;

			while (current_node.right != null) {
				current_node = current_node.right;
			}
			current_node.right = new_node;
			rear = current_node; 
		}
	}

	public int LengthOftheLinkedList() {
		Node current_node = head;
		int length = 0;

		if (current_node == null) {
			return 0;
		} else {
			while (current_node != null) {
				length++;
				current_node = current_node.right; 
			}

			return length;
		}
	}

	public void SearchElementInLinkedList(int data) {
		Node current_node = head;
		int index = 1;
		int length = LengthOftheLinkedList();

		if (current_node == null) {
			System.out.println("Empty list");
		} else {
			while (current_node != null) {
				if (current_node.data == data) {
					System.out.println(data + " is at position : " + index);
					break;
				}
				current_node = current_node.right;
				index++;
			}
		}

		if (index > length) {
			System.out.println("Element is not present in list :(");
		}
	}

	public static void main(String[] args) {
		Sequential_Search_LinkedList obj = new Sequential_Search_LinkedList();

		Scanner s = new Scanner(System.in);
		int data = 0, ch = 0;

		while (true) {
			System.out.println("1. Add");
			System.out.println("2. Search");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.AddDataIntoLinkedList(data);
					obj.PrintLinkedList();

					break;

				} case 2: {
					System.out.println("Enter data : ");
					data = s.nextInt();		

					obj.SearchElementInLinkedList(data);

					break;

				}
			}
		}
	}
}