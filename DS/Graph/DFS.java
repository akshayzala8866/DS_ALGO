import java.util.*;

public class DFS {

	public void Add_Node(int mArray[][], int data1, int data2) {
		if (data2 > mArray.length || data2 > mArray.length) {
			System.out.println("Sorry :(");
		} else {
			mArray[data1][data2] = 1;
			mArray[data2][data1] = 1;
		}
	} 

	public  void Print_Matrix(int mArray[][]) {
		for (int i = 0; i < mArray.length; i++) {
			System.out.print(i + " : ");
			for (int j : mArray[i]) {
				System.out.print(j + ", ");
			}
			System.out.println("");
		}
	}

	public void DFS_Algorithm(int mArray[][], int start, int visited[]) {
		System.out.print(start + ", ");
		visited[start] = 1;		

		for (int i = 0; i < mArray.length; i++) {
			if (mArray[start][i] == 1 && visited[i] == 0) {
				DFS_Algorithm(mArray, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		DFS obj = new DFS();
		Scanner s = new Scanner(System.in);
		int data1 = 0, data2 = 0;
		int size = 0, ch = 0;

		System.out.println("Enter nodes : ");
		size = s.nextInt();

		int mArray[][] = new int[size][size];
		int visited[] = new int[size];

		while (true) {

			System.out.println("1. Make graph");
			System.out.println("2. DFS");

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

					obj.DFS_Algorithm(mArray, 0, visited);
					System.out.println("");

					break;
				} 
			}
		}
	}	
}