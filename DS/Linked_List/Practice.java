import java.util.Scanner;

public class Practice {

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

	public void AddInBack(int data) {
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
	}

	public void AddInFront(int data) {
		Node new_node = new Node(data);
		Node temp;

		if(head == null) {
			head = new_node;
			tail = new_node;
		} else {
			temp = head;
			new_node.next = temp;
			head = new_node;
		}
	}

	public int LengthOfTheList() {
		Node current_node = head;
		int count = 0;

		if(current_node == null) {
			System.out.println("List is empty..!!");
			return 0;
		} else {
			while(current_node != null) {
				current_node = current_node.next;
				count++;
			}
		}
		return count; 
	}

	public void FindElement(int index) {
		int length = 0, counter = 1;
		length = LengthOfTheList();

		Node current_node = head;

		if(index > length) {
			System.out.println("Current length of the list is : " + length);
		} else if (counter == index && length == 1) {
			System.out.println("Value at index " + index + " is : " + current_node.data);
		} else {
			while(counter < index) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("Value at index " + index + " is : " + current_node.data);
		}
	}

	public void DisplayList() {
		Node current_node = head;

		System.out.println("*** List is ***");
		if(current_node == null) {
			System.out.println("List is empty..!!");
		} else {
			while(current_node != null) {
				System.out.print(current_node.data + "  ");
				current_node = current_node.next;
			}
		}
	}

	public void AddAfterGivenIndex(int index, int data) {
		Node new_node = new Node(data);
		Node  current_node = head;
		int counter = 1;

		int length = LengthOfTheList();

		if(index > length) {
			System.out.println("List size is : " + length);
		} else if(index == counter && length == 1) {
			tail.next = new_node;
			tail = new_node;
		} else {
			while(counter < index) {
				counter++;
				current_node = current_node.next;
			}
			Node temp = current_node.next;
			new_node.next = temp;
			current_node.next = new_node;
		}
	}

	public void AddBeforeGivenNode(int index, int data) {
		int length = 0, counter = 1;

		Node new_node = new Node(data);
		Node current_node = head;
		Node temp;

		length = LengthOfTheList();

		if(index > length) {
			System.out.println("Current length of list is : " + length); 
		} else if(counter == index && length == 1) {
			temp = current_node;
			new_node.next = temp;
			head = new_node; 
		} else {
			while (counter < index - 1) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("index : " + index + " Value : " + current_node.data);

			temp = current_node.next;
			new_node.next = temp;
			current_node.next = new_node;
		}
	}

	public void DeleteLastNode() {
		int length = 0, counter = 1;
		length = LengthOfTheList();

		Node current_node = head;

		if(length == 0) {
			System.out.println("List is empty..!!");
		} else if(length == 1) {
			head = null;
			tail = null;
		} else {
			while(counter < length - 1) {
				counter++;
				current_node = current_node.next;
			}
		}

		System.out.println("Value is : " + current_node.data);
		current_node.next = null;
		tail = current_node;
	}

	public void DeleteFirstNode() {
		Node current_node = head;
		Node temp;
		int length = 0;

		length = LengthOfTheList();

		if(length == 0) {
			System.out.println("List is empty");
		} else if(length == 1) {
			head = null;
			tail = null;
		} else {
			temp = current_node.next;
			current_node.next = null;
			head = temp;
		}
	}

	public static void main(String[] args) {
		Practice obj = new Practice();
		Scanner s = new Scanner(System.in);
		int data = 0, index = 0;

		while(true) {

			System.out.println("1. Back.");
			System.out.println("2. Front.");
			System.out.println("3. Find element in list.");
			System.out.println("4. Add After given Node");
			System.out.println("5. Add berofe given Node");
			System.out.println("6. Delete Last Node.");
			System.out.println("7. Delete First Node.");

			System.out.println("Enter your choise : ");
			int ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.AddInBack(data);

					obj.DisplayList();
					System.out.println("");

					break;

				} case 2: {

					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.AddInFront(data);

					obj.DisplayList();
					System.out.println("");

					break;

				} case 3: {
					System.out.println("Enter index : ");
					index = s.nextInt();					

					obj.FindElement(index);

					break;

				} case 4: {
					System.out.println("Index : ");
					index = s.nextInt();

					System.out.println("Value  : ");
					data = s.nextInt();
					
					obj.AddAfterGivenIndex(index, data);

					obj.DisplayList();
					System.out.println("");

					break;

				} case 5: {
					System.out.println("Index : ");
					index = s.nextInt();

					System.out.println("Value  : ");
					data = s.nextInt();
					
					obj.AddBeforeGivenNode(index, data);

					obj.DisplayList();
					System.out.println("");

					break;
				} case 6: {
					obj.DeleteLastNode();

					obj.DisplayList();
					System.out.println("");

					break;

				} case 7: {
					obj.DeleteFirstNode();

					obj.DisplayList();
					System.out.println("");

					break;

				}
			}
		}
	}
}