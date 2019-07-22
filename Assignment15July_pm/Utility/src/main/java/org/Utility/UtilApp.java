package org.Utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

/**
 * Hello world!
 *
 */
public class UtilApp {

	public static String convertToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		String jsonString;
		ObjectMapper objMapper = new ObjectMapper();
//		try {
//			jsonString = objMapper.writeValueAsString(obj);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		return (objMapper.writeValueAsString(obj));
	}
}
