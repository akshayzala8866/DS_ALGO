import java.util.Scanner;

public class Sort_Double_LinkedList {

	public class Node {
		public int data;
		public Node right;
		public Node left;

		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null; 
		}
	}

	Node head = null;
	Node tail = null;

	public void DisplayList() {
		Node current_node = head;

		if (head == null) {
			System.out.println("List is empty :(");
		} else {
			while (current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.right;
			}
			System.out.println("");

		}
	}

	public void AdddataIntoFront(int data) {
		Node new_node = new Node(data);
		Node current_node = head;

		if (head == null) {
			head = new_node;
			tail = new_node;

			head.left = null;
			tail.right = null;
		} else {
			current_node.left = new_node;
			new_node.right = head;
			new_node.left = null;
			head = new_node;
		}			
	}

	public void AdddataIntoBack(int data) {
		Node new_node = new Node(data);

		if (head == null) {
			head = new_node;
			tail = new_node;

			head.left = null;
			tail.right = null;
		} else {
			tail.right = new_node;
			new_node.left = tail;
			new_node.right = null;
			tail = new_node;
		}
	}

	public void SortTheLinkedList() {
		Node current_node = head, temp;
		int value = 0;

		if (head == null) {
			return ;
		} else if (head == tail){
			System.out.println("Head == tail");
		} else {
			while (current_node != null) {
				temp = current_node.right;

				while (temp != null) {
					if(current_node.data > temp.data) {
						value = current_node.data;
						current_node.data = temp.data;
						temp.data = value;
					}
					temp = temp.right;
				} 
				current_node = current_node.right;
			}
		}
	}

	public static void main(String[] args) {

		Sort_Double_LinkedList obj = new Sort_Double_LinkedList();

		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0;

		while (true ) {

			System.out.println("1. Insert at front.");
			System.out.println("2. Insert at Back.");
			System.out.println("3. Sort the Double linkedList ");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter Data");
					data = s.nextInt();

					obj.AdddataIntoFront(data);
					obj.DisplayList();

					break;
				} case 2: {

					System.out.println("Enter Data");
					data = s.nextInt();
	
					obj.AdddataIntoBack(data);
					obj.DisplayList();

					break;
				} case 3: {

					obj.SortTheLinkedList();
					obj.DisplayList();

					break;
				}
			}
		}		
	}
}