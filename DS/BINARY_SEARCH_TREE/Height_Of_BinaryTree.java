import java.util.*;

public class Height_Of_BinaryTree {

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
	public void InsertNode(int data) {
		Node new_data = new Node(data), current_node = null, parent_node = null;

		if (root_node == null) {
			root_node = new_data;

			return;
		} else {
			current_node = root_node;

			while (true) {	
				parent_node = current_node;

				if (data < current_node.data) {
					current_node = current_node.left;

					if (current_node == null) {
						parent_node.left = new_data;

						return;
					}
				} else {
					current_node = current_node.right;

					if (current_node == null) {
						parent_node.right = new_data;

						return;
					}
				}
			}
		}
	}  

	// public int maxheight(int left_height, int right_height) {
	// 	if (left_height > right_height) {
	// 		return left_height;
	// 	} else {
	// 		return right_height;
	// 	}
	// }

	public int HeightIs(Node root) {

		if (root == null) {
			return 0;
		} else {
			int left_height = HeightIs(root.left);
			int right_height = HeightIs(root.right);

			if (left_height > right_height) {
				return left_height + 1;
			} else {
				return right_height + 1;
			}
		}
	}

	public void DisplayTree() {
		Node current_node = root_node, temp = null;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (current_node == null) {
			return;
		} else {
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
		}

		while (!s2.isEmpty()) {
			temp = s2.pop();
			System.out.print(temp.data + ", ");  
		} 
		System.out.println("");
	}

	public static void main(String[] args) {
		Height_Of_BinaryTree obj = new Height_Of_BinaryTree();

		obj.InsertNode(15);
		obj.InsertNode(10);
		obj.InsertNode(16);
		obj.InsertNode(9);
		obj.InsertNode(14);
		obj.InsertNode(13);

		obj.DisplayTree();

		int height = obj.HeightIs(root_node);

		System.out.println("Height of the binary tree is : " + height);
	}
} 