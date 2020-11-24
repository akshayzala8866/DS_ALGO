import java.util.*;

public class Level_Order_Traversal_BST {

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

	Node root_node = null;

	public void InsertNode(int data) {
		Node new_node = new Node(data);
		Node current_node = null, parent_node = null;

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

	public void LevelOrderTraversal() {
		Node current_node = root_node;
		Queue<Node> Q = new LinkedList<Node>();

		if (root_node == null) {
			return;
		} else {
			Q.add(current_node);

			while (!Q.isEmpty()) {
				current_node = Q.poll();
				System.out.print(current_node.data + ", ");

				if (current_node.left != null) {
					Q.add(current_node.left);
				}
				if (current_node.right != null) {
					Q.add(current_node.right);
				}
			} 
			System.out.print("");
		}
	}

	public static void main(String[] args) {
		Level_Order_Traversal_BST obj = new Level_Order_Traversal_BST();

		obj.InsertNode(15);
		obj.InsertNode(10);
		obj.InsertNode(16);
		obj.InsertNode(9);
		obj.InsertNode(14);
		obj.InsertNode(13);

		System.out.print("Level order traversal is : ");
		obj.LevelOrderTraversal();

	}
}