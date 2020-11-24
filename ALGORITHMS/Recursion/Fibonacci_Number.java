import java.util.Scanner;

public class Fibonacci_Number {

	public static int Fib(int n) {

		if (n == 0 || n == 1) {
			return n; 
		}

		return (Fib(n - 1) + Fib(n - 2));
	}

	public static void PrintFibonacci(int n) {
		int temp1 = 1, temp2 = 0, ans = 0;

		System.out.print(ans + ", ");
		while (n != 0) {
			ans = temp1 + temp2;
			System.out.print(ans + ", ");
			temp1 = temp2;
			temp2 = ans;
			n--;
		}
 	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number : ");	
		int n = s.nextInt();

		System.out.println(n + " Fibonacci Number is : " + Fib(n));	
		PrintFibonacci(n);

		
	}
}