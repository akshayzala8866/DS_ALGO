import java.util.*;

public class DeleteNode_In_BST {

	public class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int data) {
			this.data = data;
			this.left = left;
			this.right = right;
		} 
	}

	Node root_node = null;

	public void PreorderTraversaal() {
		Node current_node = root_node, predessor = null;

		if (current_node == null) {
			System.out.println("Tree is empty :(");
		} else {
			while (current_node != null) {
				if (current_node.left == null) {
					System.out.println(current_node.data + ", ");
					current_node = current_node.right;
				} else {
					predessor = current_node.left;

					while (predessor.right != null && predessor.right != current_node) {
						predessor = predessor.right;
					}

					if (predessor.right == null) {
						predessor.right = current_node;
						System.out.println(current_node.data + ", ");
						current_node = current_node.left;
					} else {
						predessor.right = null;
						current_node = current_node.right;
					}
				}
			}
		}
	}

	public void InsertNode(int data) {
		Node new_node = new Node(data), current_node = null, parent_node = null;

		if (root_node == null) {
			root_node = new_node;

			return;
		} else {
			current_node = root_node;

			while (true) {
				parent_node = current_node;

				if (data < current_node.data) {
					current_node = current_node.left;

					if (current_node == null) {
						parent_node.left = new_node;
						return ;
					}
				} else {
					current_node = current_node.right;

					if (current_node == null) {
						parent_node.right = new_node;

						return;
					}
				}
			}
		}
	}

	public void DeleteNode(int data) {
		Node current_node = root_node, parent_node = null;

		while (current_node != null && current_node.data != data) {
			parent_node = current_node;

			if (data < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}

		if (current_node == null) {
			return;
		}

		if (current_node.left == null && current_node.right == null) {

			if (current_node == root_node) {
				root_node = null;
			} else {
				if (current_node == parent_node.left) {
					parent_node.left = null;
				} else {
					parent_node.right = null;
				}	
			}
		} else if (current_node.left != null && current_node.right != null) {
			Node sucessor = current_node.right;

			while (sucessor.left != null && sucessor.left != current_node) {
				sucessor = sucessor.left;
			} 

			int temp = sucessor.data;

			DeleteNode(sucessor.data);

			current_node.data = temp;
			System.out.println("sucessor is : " + sucessor.data);

		} else {
			Node child_node = null;

			if (current_node.left != null) {
				child_node = current_node.left;
			} else {
				child_node = current_node.right;
			}

			if (current_node == root_node) {
				root_node = null;
			} else {
				if (current_node == parent_node.left) {
					parent_node.left = child_node;
				} else {
					parent_node.right = child_node;
				}
			}
		}
	}

	public void PostOrderTraversal() {
		Node current_node = root_node, temp = null; 
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(current_node);

		while (!s1.isEmpty()) {
			temp = s1.pop();
			s2.push(temp);

			if (temp.left != null) {
				s1.push(temp.left);
			}
			if (temp.right != null) {
				s1.push(temp.right);
			}
		}

		while (!s2.isEmpty()) {
			temp = s2.pop();
			System.out.print(temp.data + ", ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {

		DeleteNode_In_BST obj = new DeleteNode_In_BST();

		Scanner s = new Scanner(System.in);
		int data = 0, ch = 0;

		while (true) {

			System.out.println("1. Insertion :");
			System.out.println("2. DeleteNode: ");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {

					System.out.println("Enter data : ");
					data = s.nextInt();	

					obj.InsertNode(data);
					System.out.println("Pre-order traversal : ");
					obj.PreorderTraversaal();
					System.out.println("Post-order traversal : ");
					obj.PostOrderTraversal();

					break;

				} case 2: {
					
					System.out.println("Enter data : ");
					data = s.nextInt();	

					obj.DeleteNode(data);
					System.out.println("After delete " + data + " pre-order treversal of the tree is : ");
					obj.PreorderTraversaal();

					break;

				}
			}
		}
	}
}