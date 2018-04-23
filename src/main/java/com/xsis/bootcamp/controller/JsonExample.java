package com.xsis.bootcamp.controller;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonExample {

	public static void main(String[] args) {
//		String json = "{\"bulanPanen\":[\"2\",\"5\",\"8\"]}";
//		Map<String,String> map = new HashMap<String,String>();
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

//		try {
//
//			map = mapper.readValue(json,
//	                         new TypeReference<HashMap<String,String>>(){});
////			System.out.println(map);
//
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	  }

	

}
