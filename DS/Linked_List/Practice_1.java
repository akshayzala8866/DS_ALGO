
public class Practice_1 {
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

	public int LengthOfTheList() {
		int length = 0;
		Node current_node = head;

		if (current_node == null) {
			return 0;
		} else {
			while (current_node != null) {
				current_node = current_node.next;
				length++;
			}
			return length;
		}
	}

	public void AddNodeInFront(int data) {
		Node new_node = new Node(data);
		Node current_node = head, temp;

		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			temp = current_node;
			new_node.next = temp;
			head = new_node;
		}
	}

	public void AddNodeInBack(int data) {
		Node new_node = new Node(data);
		Node current_node = head;

		if (current_node == null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
	}

	public void AddNodeAfterGivenIndex(int index, int data) {
		Node new_node = new Node(data);
		Node current_node = head, temp;
		int length = LengthOfTheList(), counter = 1;

		if (length == 0) {
			System.out.println("Length of the list is : " + length);
		} else if (index == length) {
			tail.next = new_node;
			tail = new_node;
		} else {
			while (counter < index) {
				counter++;
				current_node = current_node.next;
			}
			System.out.println("value : " + current_node.data);
			temp = current_node.next;
			current_node.next = new_node;
			new_node.next = temp;
		}
	}

	public void DisplayLinkedList() {
		Node current_node = head;
		if (head == null) {
			System.out.println("List is empty..!!");
		} else {
			while (current_node != null) {
				System.out.print(current_node.data + ", ");
				current_node = current_node.next;
			}
		} 
	}

	public void SortArrayList() {
		Node current_node = head;
		Node temp;
		int temp_value;

		if (current_node == null) {
			System.out.println("List is empty");
		} else {
			while (current_node != null) {
				temp = current_node.next;
				while (temp != null) {
					if(current_node.data > temp.data) {
						temp_value = current_node.data;
						current_node.data = temp.data;
						temp.data = temp_value;
					}
					temp = temp.next; 
				}
				current_node = current_node.next;
			}
		}
	}

	public void SortArrayList_descending() {
		Node current_node = head;
		Node temp_node;
		int value_temp;

		if (current_node == null) {
			System.out.println("List is empty..");
		} else {
			while (current_node != null) {
				temp_node = current_node.next;

				while (temp_node != null) {
					if (current_node.data < temp_node.data) {
						value_temp = current_node.data;
						current_node.data = temp_node.data;
						temp_node.data = value_temp;
					}
					temp_node = temp_node.next;
				}
				current_node = current_node.next;
			}
		}
	}

	public static void main(String[] args) {
		Practice_1 obj = new Practice_1();

		obj.AddNodeInFront(50);
		obj.AddNodeInFront(70);
		obj.AddNodeInFront(30);
		obj.AddNodeInFront(20);
		obj.AddNodeInFront(40);

		obj.AddNodeInBack(44);
		obj.AddNodeAfterGivenIndex(3, 444);



		obj.DisplayLinkedList();
		System.out.println("");

		obj.SortArrayList();

		System.out.println("Sorted array is : ");
		obj.DisplayLinkedList();
		System.out.println("");

		System.out.println("Sorted array in descending order is : ");
		obj.SortArrayList_descending();
		obj.DisplayLinkedList();
		System.out.println("");
	}	
}