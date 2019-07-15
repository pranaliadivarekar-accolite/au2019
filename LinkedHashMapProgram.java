package com.accolite.au.java;

import java.util.Scanner;

public class LinkedHashMapProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int key = 0;
		int val = 0;
		LinkedHashMapImpl lhmp = new LinkedHashMapImpl();

		while (flag) {
			System.out.println("Enter your choice: \n1.Put \n2.Delete \n3.Get \n4.Display \n5.Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter your key: ");
				key = scan.nextInt();
				System.out.print("Enter your value: ");
				val = scan.nextInt();
				lhmp.put(key, val);
				break;
			case 2:
				System.out.print("Enter your key: ");
				key = scan.nextInt();
				lhmp.delete(key);
				break;
			case 3:
				System.out.print("Enter your key: ");
				key = scan.nextInt();
				HashMapObject obj = lhmp.get(key);
				if(obj != null)
				System.out.println(obj);
				else
					System.out.println("No such key present!");
				break;
			case 4:
				lhmp.print();
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("Wrong I/P");
				break;
			}
		}
	}
}
