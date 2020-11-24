import java.util.Scanner;

public class Circular_Linked_list {

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
			System.out.println("List is empty :(");
		} else {

			do {
				System.out.print(current_node.data + ", ");
				current_node = current_node.next;
			} while (current_node != head);

			System.out.println("");
		}
	}

	public void InsertInFront(int data) {
		Node new_node = new Node(data);

		if(head == null) {
			head = new_node;
			tail = new_node;

			tail.next = head;
		} else {
			tail.next = new_node;
			new_node.next = head;
			head = new_node;
			System.out.println("head : " + head.data + " tail is : " + tail.data);
		}
	}

	public void InsertAtBack(int data) {
		Node new_node = new Node(data);

		if (head == null) {
			head = new_node;
			tail = new_node;

			tail.next = head;

			System.out.println("head : " + head.data + " tail : " + tail.data);
		} else {
			tail.next = new_node;
			new_node.next = head;
			tail = new_node;

			System.out.println("head : " + head.data + " tail : " + tail.data);
		}
	}

	public int LengthOfTheList() {
		Node current_node = head;
		int length = 0;

		if (head == null) {
			return length;
		} else {
			do {
				length++;
				current_node = current_node.next;
			} while (current_node != head);
			return length;
		}
	}

	public void InsertAfterGivenNode(int index, int data) {
		Node new_node = new Node(data);
		Node current_node = head, temp;
		int length = LengthOfTheList(), counter = 1; 

		if (head == null) {
			return ;
		} else if (index > length) {
			System.out.println("Length of the List is : " + length);
		} else if (length == index) {
			tail.next = new_node;
			new_node.next = head;
			tail = new_node;				
			System.out.println("head : " + head.data + " tail : " + tail.data);
		} else {
			while (counter < index) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("Head : " + head.data + " tail : " + tail.data);
			temp = current_node.next;
			current_node.next = new_node;
			new_node.next = temp;
		}
	}

	public void InsertBeforeGivenNode(int index, int data) {
		int length = 0, counter = 1;
		Node new_node = new Node(data), temp;
		Node current_node = head;

		length = LengthOfTheList();

		if (head == null) {
			return ;
		} else if(index > length) {
			System.out.println("Current length is : " + length);
		} else if (index == 1) {
			tail.next = new_node;
			new_node.next = head;
			head = new_node;
			System.out.println("head : " + head.data + " tail : " + tail.data);
		} else {
			while (counter < index -1) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("value : " + current_node.data);
			temp = current_node.next;
			current_node.next = new_node;
			new_node.next = temp;
		}
	}

	public void DeleteAfterGiveNode() {
		int length = 0;
		Node current_node = head, temp;
		length = LengthOfTheList();

		if (length == 1) {
			head = null;
			tail = null;
		} else if (head == null){

			return ;

		} else {

			temp = current_node.next;
			tail.next = temp;
			head = temp;

			System.out.println("Head : " + head.data + " tail : " + tail.data);

		}
	}

	public void DeleteAtBack() {

		int length = 0, counter = 1;
		Node current_node = head;
		length = LengthOfTheList();

		if(head == null) {
			return ;
		} else if (length == 1) {
			head = null;
			tail = null;
		} else {
			while (counter < length - 1) {
				current_node = current_node.next;
				counter++;
			}
			System.out.println("value : " + current_node.data);
			current_node.next = head;
			tail = current_node;
		}
	}

	public void DeleteAfterGivenNode(int index) {
		Node current_node = head, temp;
		int length = 0, counter = 1;

		length = LengthOfTheList();

		if (head == null) {
			return ;
		} else if (index == length) {
			temp = current_node.next;
			tail.next = temp;
			head = temp;

			System.out.println("head : " + head.data + " tail : " + tail.data);

		} else {

			if (index == length - 1) {
				while (counter < index) {
					counter++;
					current_node = current_node.next;
				}
				current_node.next = head;
				tail = current_node;				
			} else {
				while (counter < index) {
					current_node = current_node.next;
					counter++;
				}
				temp = current_node.next;
				current_node.next = temp.next;
			}
			System.out.println("head : " + head.data + " tail : " + tail.data);
		}
	}	

	public void DeleteBeforeGivenNode(int index) {
		int length = 0, counter = 1;
		Node current_node = head, temp;

		length = LengthOfTheList();

		if (head == null) {
			return ;
		} else if (index == 1) {
			while (counter < length - 1) {
				counter++;
				current_node = current_node.next;
			}
			current_node.next = head;
			tail = current_node;
			System.out.println("head : " + head.data + " tail  : " + tail.data);
		} else {

			if (index == 2 ) {
				temp = current_node.next;
				tail.next = temp;
				head = temp;

			} else {
				while (counter < index - 2) { 
					counter++;
					current_node = current_node.next;
				} 				
				temp = current_node.next;
				current_node.next = temp.next;
			}
			System.out.println("head : " + head.data + " tail : " + tail.data);
			
		}
	}

	public static void main(String[] args) {

		Circular_Linked_list obj = new Circular_Linked_list();

		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0, index = 0;

		while (true ) {

			System.out.println("1. Insert at front.");
			System.out.println("2. Insert at Back.");
			System.out.println("3. Insert after given index.");
			System.out.println("4. Insert before given index");
			System.out.println("5. Delete at front.");
			System.out.println("6. Delete at Back.");
			System.out.println("7. Delete after given node.");
			System.out.println("8. Delete before given Node");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {

					System.out.println("Enter Data");
					data = s.nextInt();

					obj.InsertInFront(data);
					obj.DisplayList();

					break;
				} case 2: {

					System.out.println("Enter Data");
					data = s.nextInt();

					obj.InsertAtBack(data);
					obj.DisplayList();

					break;

				} case 3: {

					System.out.println("Enter index");
					index = s.nextInt();

					System.out.println("Enter Data");
					data = s.nextInt();

					obj.InsertAfterGivenNode(index, data);
					obj.DisplayList();

					break;

				} case 4: {

					System.out.println("Enter index");
					index = s.nextInt();

					System.out.println("Enter Data");
					data = s.nextInt();

					obj.InsertBeforeGivenNode(index, data);
					obj.DisplayList();

					break;

				} case 5: {

					obj.DeleteAfterGiveNode();
					obj.DisplayList();

					break;

				} case 6: {

					obj.DeleteAtBack();
					obj.DisplayList();

					break;

				} case 7: {

					System.out.println("Enter index");
					index = s.nextInt();

					obj.DeleteAfterGivenNode(index);
					obj.DisplayList();

					break;
				} case 8: {

					System.out.println("Enter index");
					index = s.nextInt();

					obj.DeleteBeforeGivenNode(index);
					obj.DisplayList();

					break;
				}
			}
		}
	}
}