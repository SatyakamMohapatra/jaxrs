package com.satya.jersey.messages.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.satya.jersey.messages.model.MessagesModel;
import com.satya.jersey.messages.model.ProfileModel;

public class DatabaseClass {
	
	static private Map<Long,MessagesModel> Messages = new ConcurrentHashMap<Long,MessagesModel>();
	static private Map<String,ProfileModel>  Profiles = new ConcurrentHashMap<String,ProfileModel>();
	
	public static Map<Long,MessagesModel> getMessages(){
		return Messages;
	}
	public static Map<String,ProfileModel> getProfiles(){
		return Profiles;
	}

}
