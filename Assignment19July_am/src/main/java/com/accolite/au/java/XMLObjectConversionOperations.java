package com.accolite.au.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLObjectConversionOperations {
	static JAXBContext context;
	
	//Convert object to xml
	public static void convertObjectToXMLFile(String filepath, Object object) throws JAXBException {
		context = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
		marshaller.marshal(object, new File(filepath));
	}
	
	//Convert XML to Object
	public static Object convertXMLToObject(String filepath) throws JAXBException, FileNotFoundException
	{
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object object = (Object) unmarshaller.unmarshal(new FileReader(filepath));
		
		return object;
	}

}
