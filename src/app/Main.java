package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* this is where the main code runs */
	    System.out.println("Hello user! Welcome to our app.");
	    /* 1. easy */
	    // calculator();
	    //fizzBuzz();
	    //primeChecker();
	    /* 2. intermediate */
	    averageMax();
	}
	
	private static void calculator() {
		/* simple calculator - calculates based on user input
		 * .input: two numbers, one operator
		 * .output result of the operation */
		System.out.println("\n<0> Simple Calculator:");
		// 0. init
		float a = 0, b = 0;
		float res = 0;
		String op;
		Scanner sc = new Scanner(System.in);
		// 1. input
		System.out.println("> Please enter 2x numbers:");
		a = sc.nextFloat();
		b = sc.nextFloat();
		// buffered '\n' fix
		sc.nextLine();
		System.out.println("> Please enter +, -, * or /:");
		op = sc.nextLine();
		// 2. process
		switch(op.charAt(0)) {
		case '+':
			res = a + b;
			break;
		case '-':
			res = a - b;
			break;
		case '*':
			res = a * b;
			break;
		case '/':
			res = a / b;
			break;
		default:
			System.out.println("> Error: Operator not defined.");
		}
		// 3. output
		System.out.println("<0> The result is: " + res);
		sc.close();
	}
	
	private static void fizzBuzz() {
		/* fizzBuzz - iterates from 1 to 100 & follow these rules:
		 * .1 print "Fizz" for multiples of 3
		 * .2 print "Buzz" for multiples of 5
		 * .3 print "FizzBuzz" for multiples of both
		 * .4 print the number itself if none of the above are true */
		System.out.println("\n<1> FizzBuzz>:");
		// 0. init
		// 1. input
		// 2. process
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) 
				System.out.println("> FizzBuzz (" + i + ")");
			else if (i % 3 == 0) 
				System.out.println("> Fizz (" + i + ")");
			else if (i % 5 == 0) 
				System.out.println("> Buzz (" + i + ")");
			else 
				System.out.println("> " + i);
		}
		// 3. output
		System.out.println("<1> That's all folks!");
	}
	
	private static void primeChecker() {
		/* primeChecker - checks if the input number is prime
		 * .input: one number
		 * .output: true (prime), false (not) */
		System.out.println("\n<2> PrimeChecker:");
		// 0. init
		int n = 0, sqrt = 0;
		boolean res = true;
		Scanner sc = new Scanner(System.in);
		// 1. input
		System.out.println("> Please enter a number:");
		n = sc.nextInt();
		sqrt = (int) Math.sqrt(n);
		// 2. process
		for (int i = 2; i <= sqrt; i++) 
			if (n % i == 0) {
				res = false;
				break;
			}
		// 3. output
		if (res)
			System.out.println("<1> The number: " + n + " IS prime.");
		else
			System.out.println("<1> The number: " + n + " is NOT prime.");
		sc.close();
	}
	
	private static void averageMax() {
		/* averageMax - finds two values: max & mean for a given number array
		 * .input: number array of size n
		 * .output: max_value, avg_value */
		System.out.println("\n<3> Average&Max:");
		// 0. init
		float avg = 0;
		int max = 0, i;
		int array[];
		Scanner sc = new Scanner(System.in);
		// 1. input
		System.out.println("> Please enter a number array:");
		array = digits(sc.nextLine());
		// printArray(array);
		for(i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
			avg += array[i];
		}
		System.out.println("<3> Max: " + max + ", Avg: " + avg / i);
		sc.close();
	}
	
	private static int[] digits(String input) {
		/* removes everything that's not a digit from a string */ 
		int array[] = new int[input.length()];
		int output[];
		boolean num = false;
		int dig = 0, sum = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				if (!num) {
					sum += c - '0';
					num = true;
				} else {
					sum *= 10;
					sum += c - '0';
				}
			} else {
				if (num) {
					array[dig++] = sum;
					num = false;
					sum = 0;
				}
			}
		}
		// last char is digit fix
		if(num) {
			sum += input.charAt(input.length() - 1) - '0';
			array[dig++] = sum;
		}
		output = new int[dig--];
		while(dig >= 0)
			output[dig] = array[dig--];
		
		return output;
	}
	
	private static void printArray(int array[]) {
		System.out.println("_printArray_.enter");
		for (int i = 0; i < array.length; i++)
			System.out.println("[" + i + "]" + array[i]);
		System.out.println("_printArray_.exit");
	}
}
