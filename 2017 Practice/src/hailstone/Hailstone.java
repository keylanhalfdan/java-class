package hailstone;

import java.util.Scanner;

public class Hailstone {

	public static void main(String[] args) {
		int start = 0;
		int num = 0;
		int iterations = 0;
		int largest = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a whole number");
		start = input.nextInt();
		num = start;
		do {
			if (num%2 == 0) {
				num = num / 2;
				iterations++;
				if (num > largest) {
					largest = num;
				}
			}
			else {
				num = num * 3 + 1;
				iterations++;
				if (num > largest) {
					largest = num;
				}
			}
			System.out.println(num);
		}while (num != 1);
		System.out.println("Starting number: " + start + "; iterations: " + iterations + "; largerst value: " + largest);
		input.close();
	}

}
