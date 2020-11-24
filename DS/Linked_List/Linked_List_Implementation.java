import java.util.Scanner;

public class Linked_List_Implementation {

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

		if(head == null) {
			System.out.println("List is empty :(");
		} else {
			System.out.println("List are : ");
			while(current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.next;
			}	
		}
	}

	public int LengthOfTheList() {
		Node current_node = head;
		int count = 0;

		if(current_node == null) {
			return 0;
		} else {
			while(current_node != null) {
				count++;
				current_node = current_node.next;
			}			
		}

		return count;
	}

	public void AddDataIntoLinkedList(int data) {
		Node new_Node = new Node(data);

		if(head == null) {
			head = new_Node;
			tail = new_Node;
		} else {
			tail.next = new_Node;
			tail = new_Node;
		}	
	}

	public void AddDataIntoLinkedListAtBegning(int data) {
		Node new_Node = new Node(data);

		if(head == null) {
			head = new_Node;
			tail = new_Node;
		} else {
			Node temp = head;
			head = new_Node;
			head.next = temp;
		}
		DisplayList();
		System.out.println("");
	}

	public void FindValueAtGivenIndex(int index) {
		int length = 0, counter = 1;
		Node current_node = head;
		length = LengthOfTheList();

		if(index == counter) {
			System.out.println("Value at index " + index + " is : " + current_node.data);
		}

		while(current_node != null) {
			counter++;
			current_node = current_node.next;

			if(counter == index) {
				System.out.println("Value at index " + index + " is : " + current_node.data);
				break;
			}
		}
	}

	public void InsertAfterGivenNode(int index, int data) {
		int length = 0, counter = 1;
		Node new_Node = new Node(data);
		Node current_node = head;
		length = LengthOfTheList();

		if(length == counter && index == 1) {
			tail.next = new_Node;
			tail = new_Node;
		} else if(index > length) {
			System.out.println("Current length is : " + length);
		} else {
			while(counter < index) {
				counter++;
				current_node = current_node.next;
			}

			Node temp = current_node.next;
			new_Node.next = temp;
			current_node.next = new_Node;
		}
	}

	public void InsertValueBeforeGivenIndex(int index, int data) {
		Node new_Node = new Node(data);
		Node current_node = head;
		Node temp;
		int length = 0,  counter = 1;

		length = LengthOfTheList();

		if(index > length) {
			System.out.println("List length is : " + length);
		} else if(index == counter && length == 1) { 
			temp = head;
			new_Node.next = temp;
			head = new_Node;
		} else {
			while(counter < index - 1) {
				counter++;
				current_node = current_node.next;
			}
			temp = current_node.next;
			new_Node.next = temp;
			current_node.next = new_Node;
		}
	}

	public void DeleteLastNode() {
		Node current_node = head;
		int length = LengthOfTheList();
		int counter = 1;


		if(head == null) {
			System.out.println("Please enter Before Delete..!!");
		} else if(length == 1) {
			head = null;
			tail = null;
		} else {
			while(counter < length - 1) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("Value is " + current_node.data);
			current_node.next = null;
		}
	}

	public void DeleteFirstNode() {
		Node current_node = head;
		Node temp;
		int length = LengthOfTheList();

		if(length == 0) {
			System.out.println("Please ente Before Delete..!!");
		} else {
			temp = current_node.next;
			current_node.next = null;
			head = temp;
		}
	}

	public void DeleteAfterGivenNode(int index) {
		int length = 0, counter = 1;
		length = LengthOfTheList();

		Node current_node = head;
		Node temp;

		if(index >= length) {
			System.out.println("length of the List is : " + length + " Sorry bro :(");
		} else if (index == 1 && length == 1) {
			System.out.println("length of the list is  " + length + ", so cann't delete value");
		} else {
			while(counter < index) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("Value : " + current_node.data + " at index : " + index);
			temp = current_node.next;
			current_node.next = temp.next;
			temp.next = null;
		}
	}

	public void DeleteBeforeGivenNode(int index) {
		int length = 0, counter = 1;
		length = LengthOfTheList();
		Node current_node = head;
		Node temp;

		if(index > length) {
			System.out.println("List size is : " + length + " Sorry bro :(");
		} else if (index == counter) {
			System.out.println("Please choose other than 1 index");
		} else if (index == counter  + 1 || length == counter + 1) {
			temp = current_node.next;
			current_node.next = null;
			head = temp; 
		} else {
			while (counter < index - 2) {
				current_node = current_node.next;
				counter++;
			}
			System.out.println("Value : " + current_node.data + " index : " + index);
			temp = current_node.next;
			current_node.next = temp.next;
			temp.next = null;
		}
	}

	public static void main(String[] args) {

		Linked_List_Implementation obj = new Linked_List_Implementation();

		Scanner s = new Scanner(System.in);
		int data = 0, index = 0;

		while(true) {
			System.out.println("*********************");
			System.out.println("1. Insert At Front.");
			System.out.println("2. Insert At Back.");
			System.out.println("3. Find a value at given index.");
			System.out.println("4. Insert a node after given node.");
			System.out.println("5. Insert a node Before given node.");
			System.out.println("6. Delete last node.");
			System.out.println("7. Delete first node.");
			System.out.println("8. Delete After given index.");
			System.out.println("9. Delete Before given index.");
			System.out.println("*********************");
			
			System.out.println("Enter your choise : ");
			int ch = s.nextInt();

			switch(ch) {
				case 1: {
					System.out.println("Enter Data : ");
					data = s.nextInt();
					obj.AddDataIntoLinkedListAtBegning(data);

					break;

				} case 2: {
					System.out.println("Enter Data : ");
					data = s.nextInt();
					obj.AddDataIntoLinkedList(data);

					obj.DisplayList();
					System.out.println("");

					break;					

				} case 3: {
					System.out.println("Enter index value : ");
					index = s.nextInt();

					obj.FindValueAtGivenIndex(index);

					break;

				} case 4: {
					System.out.println("Enter index value : ");
					index = s.nextInt();
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertAfterGivenNode(index, data);
					obj.DisplayList();
					System.out.println("");

					break;

				} case 5: {
					System.out.println("Enter index value : ");
					index = s.nextInt();
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.InsertValueBeforeGivenIndex(index, data);
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

				} case 8: {
					System.out.println("Enter index value : ");
					index = s.nextInt();

					obj.DeleteAfterGivenNode(index);
					obj.DisplayList();
					System.out.println("");

					break;
				} case 9: {
					System.out.println("Enter index value : ");
					index = s.nextInt();

					obj.DeleteBeforeGivenNode(index);
					obj.DisplayList();
					System.out.println("");

					break;
				}
			}

		}
	}
}