import java.util.*;

public class Practice_BST {

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

	public void LeafNode(Node root) {
		if (root == null) {
			return;
		} else {
			if (root.left == null && root.right == null) {
				System.out.print(root.data + ", ");
			} else {
				if (root.left != null) {
					LeafNode(root.left);
				}
				if (root.right != null) {
					LeafNode(root.right);
				}
			}
		}
	}

	public void PrintLevelByLevel() {
		Node current_node = root_node, temp = null;

		if (current_node == null) {
			System.out.println("Tree is Empty");
		} else {
			Queue<Node> q1 = new LinkedList<Node>(); 
			Queue<Node> q2 = new LinkedList<Node>(); 

			System.out.println("");

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
		} else if (current_node.right != null && current_node.left != null) {
			Node successor = current_node.right;

			while (successor.left != null && successor != current_node) {
				successor = successor.left;
			}

			int temp = successor.data;

			DeleteNode(successor.data);

			current_node.data = temp;
		} else {
			Node child_node = null;

			if (current_node.left != null) {
				child_node = current_node.left;
			} else {
				child_node = current_node.right;				
			}

			if (parent_node.left == current_node) {
				parent_node.left = child_node;
			} else {
				parent_node.right = child_node;
			}
		}
		System.out.println(root_node.data + ", ");
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

	public void SearchNode(int data) {
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
			System.out.println("data is not present :(");
		} else {
			if (current_node == parent_node.left) {
				System.out.println(data + " is left child of " + parent_node.data);
			} else {
				System.out.println(data + " is right child of " + parent_node.data);
			}
		}
	}

	public static void main(String[] args) {
		Practice_BST obj = new Practice_BST();

		obj.InsertNode(15);
		obj.InsertNode(10);
		obj.InsertNode(16);
		obj.InsertNode(9);
		obj.InsertNode(14);
		obj.InsertNode(13);

		obj.DisplayTree();

		// obj.DeleteNode(9);
		// System.out.println("After delete 7");

		System.out.println("Search element : ");
		obj.SearchNode(14);		
		obj.DisplayTree();
		obj.PrintLevelByLevel();
		System.out.println("Leaf nodes are : ");
		obj.LeafNode(root_node);
	}
}