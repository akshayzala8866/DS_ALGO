import java.util.*;

public class AVL_Tree_Insertion {

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

	public Node LeftRotation(Node root) {
		Node new_Root = root.right;
		root.right = root.right.left;
		new_Root.left = root;

		return new_Root;   
	}

	public Node RightRotation(Node root) {
		Node new_Root = root.left;
		root.left = root.left.right;
		new_Root.right = root;

		return new_Root; 
	}

	public int HeightOfTree(Node root) {
		if (root == null) {
			return 0; 
		} else {
			int left_H = HeightOfTree(root.left);
			int right_H = HeightOfTree(root.right);

			if (left_H > right_H) {
				return left_H + 1;
			} else {
				return right_H + 1;
			}
		}
	}

	public int Balance_Factor(Node rootLeft, Node rootRight) {
		return HeightOfTree(rootLeft) - HeightOfTree(rootRight);
	} 	

	public Node InsertNode(Node root, int data) {
		Node new_node = new Node(data);

		if (root == null) {
			root = new_node;
			return root;
		} else {
			if (data < root.data) {
				root.left = InsertNode(root.left, data);
			} else {
				root.right = InsertNode(root.right, data);
			}
		}

		int balance = Balance_Factor(root.left, root.right);

		if (balance > 1) {
			if (HeightOfTree(root.left.left) >= HeightOfTree(root.left.right)) {
				//right rotation
				root = RightRotation(root);
			} else {
				//LR rotation
				root.left = LeftRotation(root.left); //left Rotate
				root = RightRotation(root); //right rotate
			}
		}

		if (balance < -1) {
			if (HeightOfTree(root.right.right) >= HeightOfTree(root.right.left)) {
				root = LeftRotation(root);
			} else {
				root.right = RightRotation(root.right);
				root = LeftRotation(root);
			}
		}
		return root;
	}

	public void DisplayPostOrderTraversal() {
		Node current_node = root_node, temp = null;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (root_node == null) {
			System.out.println("Tree is empty :(");
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

			while (!s2.isEmpty()) {
				temp = s2.pop();

				System.out.print(temp.data + ", ");
			}
			System.out.println("");
		}
	}

	public void DisplayInOrderTraversal() {
		Node current_node = root_node, predecessor = null;

		while (current_node != null) {
			if (current_node.left == null) {
				System.out.print(current_node.data + ", ");
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
					System.out.print(current_node.data + ", ");
					current_node = current_node.right;
				}
			} 
		}
	}

	public void LeveByLevel() {
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
			System.out.println("root node : " + root_node.data);
		}
	}

	public void SearchElement(int data) {
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
			System.out.println(data + " is not present :(");
		} else {

			if (current_node == root_node) {
				System.out.println(data + " is root node of the Tree");
			} else {
				if (parent_node.left == current_node) {
					System.out.println(data + " is left child of " + parent_node.data);
				} else {
					System.out.println(data + " is right child of " + parent_node.data);
				}	
			}
		}
	}

	public static void main(String[] args) {
		AVL_Tree_Insertion obj = new AVL_Tree_Insertion();
		int data = 0, ch = 0; 
		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("1. insertion : ");
			System.out.println("2. Search Element :");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1:{
					System.out.println("Enter data : ");
					data = s.nextInt();

					root_node = obj.InsertNode(root_node, data);

					// System.out.println("Post-order trversal is : ");
					// obj.DisplayPostOrderTraversal();
					// System.out.println("In-order trversal is : ");
					// obj.DisplayInOrderTraversal();
					System.out.println("Level by Level : ");
					obj.LeveByLevel();

					break;
				} case 2: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.SearchElement(data);

					break;
				}
			}
		}
	}
}