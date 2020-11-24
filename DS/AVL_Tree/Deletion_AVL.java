import java.util.*;

public class Deletion_AVL {

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static Node root_node = null;

	public Node RightRotation(Node root) {
		Node newRoot = root.left;
		root.left = root.left.right;
		newRoot.right = root;

		return newRoot;
	}

	public Node LeftRotation(Node root) {
		Node newRoot = root.right;
		root.right = root.right.left;
		newRoot.left = root;

		return newRoot;
	}

	public int HeighOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int height_L = HeighOfTree(root.left);
			int height_R = HeighOfTree(root.right);

			if (height_L > height_R) {
				return height_L + 1;
			} else {
				return height_R + 1;
			}
		} 
	}

	public int Balance_Factor(Node rootL, Node rootR) {
		return HeighOfTree(rootL) - HeighOfTree(rootR);
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

		int balance = Balance_Factor(root.left, root.right);

		root = Balance_AVL_Tree(root, balance);

		return root;
	}

	public Node Balance_AVL_Tree(Node root, int balance) {

		if (balance > 1) {
			if (HeighOfTree(root.left.left) >= HeighOfTree(root.left.right)) {
				//right Rotation
				root = RightRotation(root);
			} else {
				root.left = LeftRotation(root.left);
				root = RightRotation(root);
			}
		}

		if (balance < -1) {
			if (HeighOfTree(root.right.right) >= HeighOfTree(root.right.left)) {
				root = LeftRotation(root);
			} else {
				root.right = RightRotation(root.right);
				root = LeftRotation(root);
			}
		}

		return root;
	}

	public Node DeleteNode(Node root, int data) {
		Node current_node = root, parent_node = null, child_node = null;
		System.out.println("current_node : " + current_node.data);

		while (current_node != null && current_node.data != data) {
			parent_node = current_node;
			if (data < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}

		if (current_node == null) {
			return null;
		}
		System.out.println("parent_node : " + parent_node.data);

		if (current_node.left == null && current_node.right == null) {
			if (current_node == root_node) {
				root_node = null;
			} else {
				if (parent_node.left == current_node) {
					parent_node.left = null;
				} else {
					parent_node.right = null;
				}
			}
		} else if (current_node.left != null && current_node.right != null){
			Node sucessor = current_node.right;

			while (sucessor.left != null && sucessor.left != current_node) {
				sucessor = sucessor.left;
			}

			int temp = sucessor.data;

			DeleteNode(sucessor, sucessor.data);

			current_node.data = temp;
		} else {
			if (current_node.left != null) {
				child_node = current_node.left;
			} else {
				child_node = current_node.right;
			}

			if (current_node == root_node) {
				root_node = child_node;
			} else {
				if (parent_node.left == current_node) {
					parent_node.left = child_node;
				} else {
					parent_node.right = child_node;
				}
			}			
		}

		int balance = Balance_Factor(parent_node.left, parent_node.right);
		System.out.println("balance factor : " + root_node.data + " , " + balance);

		root_node = Balance_AVL_Tree(parent_node, balance);
		System.out.println("Root node is : " + root_node.data + " , " + balance);

		return root_node;
	}

	public void  LeveByLevel() {
		Node current_node = root_node, temp = null;
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();

		q1.add(current_node);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				temp = q1.poll();
				System.out.print(temp.data + ", ") ;

				if (temp.left != null) {
					q2.add(temp.left);
				} 
				if (temp.right != null) {
					q2.add(temp.right);
				}
			}
			System.out.println("") ;

			while (!q2.isEmpty()) {
				temp = q2.poll();
				System.out.print(temp.data + ", ") ;

				if (temp.left != null) {
					q1.add(temp.left);
				} 
				if (temp.right != null) {
					q1.add(temp.right);
				}
			}
			System.out.println("") ;
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
				System.out.println(data + " is root node of the tree..!!");
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
		Deletion_AVL obj = new Deletion_AVL();
		Scanner s = new Scanner(System.in);
		int ch = 0, data = 0;

		while (true) {
			System.out.println("1. insertion : ");
			System.out.println("2. Deletion :");
			System.out.println("3. Searching :");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1:{
					System.out.println("Enter data : ");
					data = s.nextInt();

					root_node = obj.InsertNode(root_node, data);

					System.out.println("Level by Level : ");
					obj.LeveByLevel();

					break;
				} case 2: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					root_node = obj.DeleteNode(root_node, data);
					System.out.println("ROOT : " + root_node.data);
					obj.LeveByLevel();

					break;
				} case 3: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.SearchElement(data);

					break;
				} 
			}
		}
	}
}