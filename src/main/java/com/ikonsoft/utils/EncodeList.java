package com.ikonsoft.utils;

import java.lang.reflect.Type;

import java.util.List;




import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ikonsoft.model.User;

public class EncodeList {
	
	
	public static List<User> convertToList(String json){
		Gson gsonReceiver = new Gson();
		// the TypeToken could be List of object instead of String
		Type type = new TypeToken<List<User>>(){}.getType();
		//this list could be list of object instead of String
		 List<User> list = gsonReceiver.fromJson(json,type);
		 return list;
	}
	public static String convertToJson(List<User>list){
		//the list could be list of object instead of String
		String json = new Gson().toJson(list);
		return json;
	}
}
