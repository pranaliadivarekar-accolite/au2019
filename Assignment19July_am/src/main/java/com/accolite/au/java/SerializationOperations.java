package com.accolite.au.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SerializationOperations {

	FileOutputStream outStream;
	FileInputStream inStream;

	//Serializing Object
	public void writeObjectToFile(List<Student> listOfStudents, String filepath) {
		try {
			outStream = new FileOutputStream(filepath);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			objectOutputStream.writeObject(listOfStudents);
			objectOutputStream.close();
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//De-serializing Object
	public List<Student> readObjectFromFile(String filepath) {
		List<Student> listOfStudents = null;
		try {
			inStream = new FileInputStream(filepath);
			ObjectInputStream objectInputStream = new ObjectInputStream(inStream);
			listOfStudents = (List<Student>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			return listOfStudents;
		}

	}

}
