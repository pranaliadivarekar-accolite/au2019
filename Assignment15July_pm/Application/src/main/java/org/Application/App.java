package org.Application;

import org.Utility.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class App 
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		List<Integer> l = new ArrayList();
		l.add(1);
		l.add(2);
		l.add(3);
		UtilApp ut = new UtilApp();
		System.out.println(ut.convertToJson(l));
		
	}
}
