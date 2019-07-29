package com.accolite.au.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Q2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Employee employee;
		Address address;
		String filepath = null;

		// Read input from user
		employee = new Employee();
		address = new Address();
		System.out.println("Enter First Name: ");
		employee.setFirstName(scan.next());
		System.out.println("Enter Last Name: ");
		employee.setLastName(scan.next());
		System.out.println("Enter Id Name: ");
		employee.setEmpId(scan.nextInt());
		System.out.println("Enter Address - Street Name: ");
		address.setStreet(scan.nextLine());
		System.out.println("Enter Address - City Name: ");
		address.setCity(scan.nextLine());
		System.out.println("Enter Address - State Name: ");
		address.setState(scan.nextLine());
		System.out.println("Enter Address - Zip Name: ");
		address.setZip(scan.nextInt());
		employee.setAddress(address);
		System.out.println("Enter Filepath to store: ");
		filepath = scan.next();

		XMLObjectConversionOperations ops = new XMLObjectConversionOperations();
		try {
			ops.convertObjectToXMLFile(filepath, employee);
			System.out.println("Object stored in XML format in file " + filepath);
			System.out.println("Converting XML into Object...");
			Employee convertedObj = (Employee) ops.convertXMLToObject(filepath);
			System.out.println("Converted object: \n" + convertedObj);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
