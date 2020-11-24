import java.util.*;

public class BFS {

	public void Add_Node(int mArray[][], int data1, int data2) {
		if (data1 > mArray.length && data2 > mArray.length) {
			System.out.println("Sorry :(");
		} else {
			mArray[data1][data2] = 1;
			mArray[data2][data1] = 1;
		}
	}

	public void Print_Matrix(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(i + " : ");
			for (int j = 0; j <  mArray.length; j++) {
				System.out.print(mArray[i][j] + ", ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void BFS_Algorithm(int mArray[][], int statr, int visited[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		int top = 0;
		q.add(statr);
		visited[statr] = 1;

		while (!q.isEmpty()) {
			top = q.remove();

			System.out.print(top + ", ");

			for (int i = 0; i < mArray.length; i++) {
				if (mArray[top][i] == 1 && visited[i] ==0) {
					q.add(i);

					visited[i] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS obj = new BFS();
		Scanner s = new Scanner(System.in);

		int mArray[][];
		int visited[];
		int ch = 0, data1 = 0, data2 = 0, size = 0;

		System.out.println("Enter size : ");
		size = s.nextInt();
		mArray = new int[size][size];
		visited = new int[size];

		while (true) {

			System.out.println("1. Make graph");
			System.out.println("2. BFS");

			System.out.println("Enter your choice : ");
			ch = s.nextInt();

			switch (ch) {
				case 1: {
					System.out.println("");
					System.out.println("Enter data1  :");
					data1 = s.nextInt(); 

					System.out.println("Enter data2  :");
					data2 = s.nextInt();

					obj.Add_Node(mArray, data1, data2);
					obj.Print_Matrix(mArray);

					break;
				} case 2: {
					for (int i = 0; i < visited.length; i++) {
						visited[i] = 0;
					}
					obj.BFS_Algorithm(mArray, 2, visited);
					System.out.println("");

					break;
				} 
			}
		}
	}
}