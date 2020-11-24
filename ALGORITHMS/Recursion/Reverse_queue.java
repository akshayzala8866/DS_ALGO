import java.util.*;

public class Reverse_queue {
	public static Queue<Integer> q = new LinkedList<Integer>();

	public static Queue<Integer> reverse(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return queue;
		}

		int temp = queue.peek();
		queue.remove();

		queue = reverse(queue);

		queue.add(temp);
		return queue;		
	}

	public static void main(String[] args) {
		q.add(1);	
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q);
		q = reverse(q);
		System.out.println(q);
	}
}