import java.util.*;

public class Practice_AVL {

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null; 
		}
	}

	static Node root_node = null;

	public int HeightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int root_L = HeightOfTree(root.left);
			int root_R = HeightOfTree(root.right);

			if (root_L > root_R) {
				return root_L + 1;
			} else {
				return root_R + 1;
			}
		}
	}

	public int Balance_factor(Node rootLeft, Node rootRight ) {
		return HeightOfTree(rootLeft) - HeightOfTree(rootRight); 
	}

	public Node RightRotation(Node root) {
		Node newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;

		return newRoot;
	}

	public Node LeftRotatino(Node root) {
		Node newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;

		return newRoot; 
	}

	public Node InsertNode(Node root, int data) {
		Node new_node = new Node(data);

		if (root == null) {
			root = new_node;
		} else {
			if (data < root.data) {
				root.left = InsertNode(root.left, data);
			} else {
				root.right = InsertNode(root.right, data);
			}
		}

		int balance = Balance_factor(root.left, root.right);

		System.out.println("balance : " + root.data + " is : " + balance);

		if (balance > 1) {
			if (HeightOfTree(root.left.left) >= HeightOfTree(root.left.right)) {
				root = RightRotation(root);
			} else {
				System.out.println("balance :(");
				root.left = LeftRotatino(root.left);
				root = RightRotation(root);
			}
 		}

 		if (balance < -1) {
 			if (HeightOfTree(root.right.right) >= HeightOfTree(root.right.left)) {
 				root = LeftRotatino(root);
 			} else {
 				root.right = RightRotation(root.right);
 				root = LeftRotatino(root);
 			}
 		}
 		System.out.println("Root Node : " + root.data);
		return root;
	}

	public void DisplayLevelByLevel() {
		Node current_node = root_node, temp = null;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		if (current_node == null) {
			System.out.println("tree is empty :(");
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
		}
	}

	public static void main(String[] args) {
		Practice_AVL obj = new Practice_AVL();
		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0;

		while (true) {
			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter data : ");
					data = s.nextInt();
					root_node = obj.InsertNode(root_node, data);

					System.out.println("Print level by level : ");
					obj.DisplayLevelByLevel();

					break;
				}
			}
		}
	}
}