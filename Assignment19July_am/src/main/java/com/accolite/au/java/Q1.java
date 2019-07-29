package com.accolite.au.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {

		List<Student> listOfStudent = new ArrayList<Student>();
		Scanner scan = new Scanner(System.in);
		Student student;
		Address address;
		String filepath = null;
		
		//Read input from user
		for(int i = 0; i<2; i++)
		{
			System.out.println("=============Student"+(i+1)+"=============");
			student = new Student();
			address = new Address();
			System.out.println("Enter First Name: " );
			student.setFirstName(scan.next());
			System.out.println("Enter Last Name: " );
			student.setLastName(scan.next());
			System.out.println("Enter Id Name: " );
			student.setStudentId(scan.nextInt());
			System.out.println("Enter Standard Name: " );
			student.setStandard(scan.nextInt());
			System.out.println("Enter Division Name: " );
			student.setDivision(scan.nextInt());
			System.out.println("Enter Marks Name: " );
			student.setMarks(scan.nextInt());
			System.out.println("Enter Address - Street Name: " );
			address.setStreet(scan.nextLine());
			System.out.println("Enter Address - City Name: " );
			address.setCity(scan.nextLine());
			System.out.println("Enter Address - State Name: " );
			address.setState(scan.nextLine());
			System.out.println("Enter Address - Zip Name: " );
			address.setZip(scan.nextInt());
			student.setAddress(address);
			listOfStudent.add(student);
		}

		System.out.println("Enter Filepath to store: " );
		filepath = scan.next();
		
		SerializationOperations ops = new SerializationOperations();
		ops.writeObjectToFile(listOfStudent, filepath);
		System.out.println("Object successfully serialized");
		
		System.out.println("Deserialized Object: \n"+ops.readObjectFromFile(filepath));
	}

}
