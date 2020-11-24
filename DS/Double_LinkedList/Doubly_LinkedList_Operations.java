import java.util.Scanner;

public class Doubly_LinkedList_Operations {

	public class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	Node head = null;
	Node tail = null;

	public int LengthOfTheList() {
		Node current_node = head;
		int length = 0;

		if (head == null) {
			return 0;	
		} else {
			while (current_node != null) {
				length ++;
				current_node = current_node.right;
			}
			return length;
		}
	}

	public void DisplayLinkedList() {
		Node current_node = head;

		if (head == null) {
			System.out.println("Linked List is empty :(");
		} else {
			System.out.println("**** **** Double LinkedList **** ****");
			while (current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.right;
			}
			System.out.println("");
			System.out.println("**** **** **** **** **** **** **** ****");
		}
	}

	public void InsertAtBack(int data) {
		Node new_node = new Node(data);

		if (head == null) {
			head = new_node;
			tail = new_node;

			head.left = null;
			tail.right = null;
		} else {
			tail.right = new_node;
			new_node.left = tail;
			tail = new_node;
			tail.right = null;
		}
	}

	public void InsertAtFront(int data) {
		Node new_node = new Node(data);

		if (head == null) {
			head = new_node;
			tail = new_node;

			head.left = null;
			tail.right = null;
		} else {
			head.left = new_node;
			new_node.right = head;
			head = new_node;
			head.left = null;
		}
	}

	public void DeleteAtBack() {
		Node current_node;
		int length = LengthOfTheList();

		if(head == null) {
			return;
		} else if (length == 1){
			head = null;
			tail = null;
		} else {
			current_node = tail.left;
			current_node.right = null;
			tail.left = null;
			tail = current_node; 
		}
	}

	public void DeleteAtFront() {
		int length = LengthOfTheList();
		Node current_node = head;

		if (head == null) {
			return ;
		} else if (length == 1) {
			head = null;
			tail = null;
		} else {
			current_node = head.right;
			head.right = null;
			current_node.left = null;
			head = current_node; 
		}
	}

	public void InsertAfterGivenIndex(int index, int data) {
		int length = 0, counter = 1;
		Node current_node = head, temp;
		Node new_node = new Node(data);

		length = LengthOfTheList();

		if (index  > length) {
			System.out.println("size of the list is : " + length);
		} else if (index == length) {

			tail.right = new_node;
			new_node.left = tail;
			new_node.right = null;
			tail = new_node; 

		} else {

			while (counter < index) {
				counter++;
				current_node = current_node.right;
			}
			temp = current_node.right;
			current_node.right = new_node;
			new_node.left = current_node;
			temp.left = new_node.right;
			new_node.right = temp;

		}
	}	

	public void InsertBeforeGivenIndex(int index, int data) {
		int length = 0, counter = 1;
		Node new_node = new Node(data);
		Node current_node = head, temp;

		length = LengthOfTheList();

		if (head == null) {
			System.out.println("List is empty :(");
		} else if (length == 1 && index == 1) {
			head.left = new_node;
			new_node.right = head;
			new_node.left = null;
			head = new_node;
		} else  if (index == 1) {

			current_node.left = new_node;
			new_node.right = current_node;
			new_node.left = null;
			head = new_node; 
		} else {
			while (counter < index - 1) {
				counter++;
				current_node = current_node.right;
			}
			System.out.println("value : " + current_node.data + " index is : " + counter); 
			temp = current_node.right;
			current_node.right = new_node;
			new_node.left = current_node.right;
			new_node.right = temp;
			temp.left = new_node; 
		}
	}

	public void DeleteAfterGivenNode(int index) {
		int length = 0, counter = 1;
		Node current_node = head, temp;

		length = LengthOfTheList();

		if (head == null) {
			return ;
		} else if (index >= length){
			System.out.println("Size of the list is : " + length);
		} else if (index == length - 1) {

			current_node = tail.left;
			current_node.right = null;
			tail = current_node;

			System.out.println("value tail " + tail.data);

		} else {
			while (counter < index) {
				current_node = current_node.right;
				counter++;
			}
			System.out.println("value : " + current_node.data);
			temp = current_node.right;
			temp.left = null;
			current_node.right = temp.right;
			temp.right = current_node;
			System.out.println("value tail : " + tail.data);			
		}
	}

	public void DeleteBeforeGivenNode(int index) {
		int length = 0, counter = 1;
		Node current_node = head, temp;
		length = LengthOfTheList();
		if (head == null) {
			return;
		} else if (index == 1){
			return;
		} else if (index == 2){
			current_node = current_node.right;
			current_node.left = null;
			head = current_node;

			System.out.println("Head : " + head.data);
			System.out.println("tail : " + tail.data);			

		} else {
			while (counter < index - 2) {
				current_node = current_node.right;
				counter++;
			}
			System.out.println("value : " + current_node.data);
			temp = current_node.right;
			current_node.right = temp.right;
			temp.left = current_node;
		}
	}

	public static void main(String[] args) {

		Doubly_LinkedList_Operations obj = new Doubly_LinkedList_Operations();

		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0, index = 0;

		while (true) {
			System.out.println("1. Insert at Back.");
			System.out.println("2. Insert at Front.");
			System.out.println("3. Delete at Back.");
			System.out.println("4. Delete at Front.");
			System.out.println("5. Insert after given Index.");
			System.out.println("6. Insert before given Index.");
			System.out.println("7. Delete after given Index.");
			System.out.println("8. Delete before given Index.");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertAtBack(data);
					obj.DisplayLinkedList();

					break;

				} case 2: {

					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertAtFront(data);
					obj.DisplayLinkedList();

					break;

				} case 3: {
					obj.DeleteAtBack();
					obj.DisplayLinkedList();

					break;
				} case 4: {

					obj.DeleteAtFront();
					obj.DisplayLinkedList();

					break;

				} case 5: {
					System.out.println("Enter index : ");
					index = s.nextInt();

					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertAfterGivenIndex(index, data);
					obj.DisplayLinkedList();

					break;

				} case 6: {
					System.out.println("Enter index : ");
					index = s.nextInt();

					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertBeforeGivenIndex(index, data);
					obj.DisplayLinkedList();

					break;

				} case 7: {
					System.out.println("Enter Index : ");
					index = s.nextInt();

					obj.DeleteAfterGivenNode(index);
					obj.DisplayLinkedList();

					break;

				} case 8: {
					System.out.println("Enter Index : ");
					index = s.nextInt();

					obj.DeleteBeforeGivenNode(index);
					obj.DisplayLinkedList();

					break;

				}
			}
		}
	}
}