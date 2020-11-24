import java.util.*;

public class BST_Insert_Inorder_Traversal {

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

	public static Node root = null;

	public void insert(int data) {
		Node new_node = new Node(data), current_node = null, parent_node = null;

		if (root == null) {
			root = new_node;
			return;
		} else {
			current_node = root;

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

	public void MorrisInorderTraversal() {
		Node current_node = root, predesser = null;

		while (current_node != null) {
			if (current_node.left == null) {
				System.out.println(current_node.data + ",  ");
				current_node = current_node.right;
			} else {
				predesser = current_node.left;

				while (predesser.right != null && predesser.right != current_node) {
					predesser = predesser.right;
				}

				if (predesser.right == null) {
					predesser.right = current_node;
					current_node = current_node.left;
				} else {
					predesser.right = null;
					System.out.println(current_node.data + ",  ");
					current_node = current_node.right;
				}
			}
		}
	}

	public void Iterative_PostorderTraversal() {
		Node current_node = root, temp;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (current_node == null) {
			return ;
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
			System.out.print(temp.data + ",  "); 
		}
		System.out.println(""); 

	}

	public void MorrisPreorderTraversal() {
		Node current_node = root, predesser = null;

		while (current_node != null) {
			if (current_node.left == null) {
				System.out.println(current_node.data + ", ");
				current_node = current_node.right;
			} else {
				predesser = current_node.left;

				while (predesser.right != null && predesser.right != current_node) {
					predesser = predesser.right;
				}

				if (predesser.right == null) {
					predesser.right = current_node;
					System.out.println(current_node.data + ", ");
					current_node = current_node.left;
				} else {
					predesser.right = null;
					current_node = current_node.right;
				}
			}
		}
	}

	public void SearchElementInTree(int data) {
		Node current_node = root, parent_node = null;

		while (current_node != null && current_node.data != data) {
			parent_node = current_node;

			if (data < current_node.data) {
				current_node = current_node.left;
			} else {
				current_node = current_node.right;
			}
		}

		if (current_node == null) {
			System.out.println("no element is present in tree :(");
		} else if (current_node.data == data){
			System.out.println(current_node.data + " is root Node of the tree..");
		} else {
			if (current_node.data < parent_node.data) {
				System.out.println(data + " is left child of " + parent_node.data);
			} else {
				System.out.println(data + " is right child of " + parent_node.data);
			}
		} 
	}

	public static void main(String[] args) {

		BST_Insert_Inorder_Traversal obj = new BST_Insert_Inorder_Traversal();

		Scanner s = new Scanner(System.in);
		int ch = 0, data;

		while (true) {
			System.out.println("1. Insert data into Tree.");
			System.out.println("2. Serach element in tree");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("Enter Data : ");
					data = s.nextInt();

					obj.insert(data);
					System.out.println("Inorder Traversal : ");
					obj.MorrisInorderTraversal();
					System.out.println("Pre-order Traversal : ");
					obj.MorrisPreorderTraversal();
					System.out.println("Post-order Traversal : ");
					obj.Iterative_PostorderTraversal();

					break;

				} case 2: {
					System.out.println("Enter data : ");
					data = s.nextInt();

					obj.SearchElementInTree(data);

					break;

				}
			}
		}		
	}	
}