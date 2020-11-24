import java.util.Scanner;

public class Print_Leaf_Node_IN_BST {

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

	static Node root_node = null;
	static int sum = 0;

	public void countLeafNodes(Node root) {

		Node current_node = root;

		if (root != null) {
			if (root.left == null && root.right == null) {
				System.out.print(root.data + " ");
				sum += root.data;
			} else {
				if (root.left != null) {
					countLeafNodes(root.left);
				}
				if (root.right != null) {
					countLeafNodes(root.right);
				}
			}
		}
	}

	public void InOrderTraversal() {
		Node current_node = root_node, predecessor = null;

		while (current_node != null) {
			if (current_node.left == null) {
				System.out.println(current_node.data + ", ");
				current_node = current_node.right;
			} else {
				predecessor = current_node.left;

				while (predecessor.right != null && predecessor.right != current_node) {
					predecessor = predecessor.right;
				}

				if (predecessor.right == null) {
					predecessor.right = current_node;
					current_node = current_node.left;
				} else {
					predecessor.right = null;
					System.out.println(current_node.data + ", ");
					current_node = current_node.right;
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
						return;
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

	public static void main(String[] args) {

		Print_Leaf_Node_IN_BST obj = new Print_Leaf_Node_IN_BST();

		Scanner s = new Scanner(System.in);
		int data = 0, ch = 0;

		while (true) {

			System.out.println("1. Insertion.");
			System.out.println("2. Count leaf nodes.");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {

					System.out.println("Enter data : ");
					data = s.nextInt();	

					obj.InsertNode(data);
					System.out.println("In-order traversal : ");
					obj.InOrderTraversal();

					break;

				} case 2: {

					System.out.print("leaf node are : ");
					obj.countLeafNodes(root_node);
					System.out.println("sum is : " + sum);
					break;

				}
			}
		}		
	}
}