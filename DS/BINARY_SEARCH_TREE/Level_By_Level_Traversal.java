import java.util.*;

public class Level_By_Level_Traversal {

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = left;
			this.right = right;
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

	public void LevelByLevelTraversal() {
		Node current_node = root_node, temp = null;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		if (current_node == null) {
			return;
		} else {
			q1.add(current_node);

			while (!q1.isEmpty() || !q2.isEmpty()) {
				while (!q1.isEmpty()) {
					temp = q1.poll();
					System.out.print(temp.data + ", ");

					if (temp.left != null) {
						q2.add(temp.left);
					}
					if (temp.right != null) {
						q2.add(temp.right);
					}
				}

				System.out.println("");

				while (!q2.isEmpty()) {
					temp = q2.poll();
					System.out.print(temp.data + ", ");

					if (temp.left != null) {
						q1.add(temp.left);
					} 
					if (temp.right != null) {
						q1.add(temp.right);
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}

	public void PostOrderTraversal() {
		Node current_node = root_node;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (current_node == null) {
			return;
		} else {
			s1.push(current_node);

			while (!s1.isEmpty()) {
				current_node = s1.pop();
				s2.push(current_node);

				if (current_node.left != null) {
					s1.push(current_node.left);
				}
				if (current_node.right != null) {
					s1.push(current_node.right);
				}
			} 

			while (!s2.isEmpty()) {
				current_node = s2.pop();
				System.out.print(current_node.data + ", ");
			}
			System.out.println("");
		}
	}

	public void SerachElement(int data) {
		Node current_node = root_node;
		Node parent_node = null;

		while (current_node != null && current_node.data != data) {
			parent_node = current_node;

			if (data < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}			
		}

		if (current_node == null) {
			System.out.println("Element is not present in tree");
		} else {
			if (current_node == root_node) {
				System.out.println("its a root node");
			} else {
				if (parent_node.left == current_node) {
					System.out.println(current_node.data + " is left child of " + parent_node.data);
				} else {
					System.out.println(current_node.data + " is right child of " + parent_node.data);
				}
			}
		}		
	}

	public static void main(String[] args) {

		Level_By_Level_Traversal obj = new Level_By_Level_Traversal();


		obj.InsertNode(3);
		obj.InsertNode(2);
		obj.InsertNode(5);
		obj.InsertNode(4);
		obj.InsertNode(6);
		obj.InsertNode(8);
		obj.InsertNode(7);

		System.out.print("Level order traversal is : ");
		obj.LevelByLevelTraversal();
		obj.PostOrderTraversal();
		obj.SerachElement(10);
	}
}
