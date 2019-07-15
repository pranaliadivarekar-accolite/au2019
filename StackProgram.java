package com.accolite.au.java;

import java.util.Scanner;

public class StackProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StackImpl s = new StackImpl();
		boolean flag = true;
		
		while (flag) {
			System.out.println("Enter your choice: \n1.Push \n2.Pop \n3.Print \n4.Is Empty \n5.Is Full \n6. Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter your value");
				int val = scan.nextInt();
				s.push(val);
				break;
			case 2:
				s.pop();
				break;
			case 3:
				s.display();
				break;
			case 4:
				System.out.println(s.isEmpty());
				break;
			case 5:
				System.out.println(s.isFull());
				break;
			case 6:
				flag = false;
			default:
				break;
			}
			
		}

	}

}
