package org.Utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class UtilApp {

	public static String convertToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objMapper = new ObjectMapper();
		return (objMapper.writeValueAsString(obj));
	}
}
